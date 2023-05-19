package com.power.dao;

import com.sun.management.OperatingSystemMXBean;
import oshi.hardware.CentralProcessor;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SystemInfoDao{
    private oshi.SystemInfo systemInfo = new oshi.SystemInfo();
    public Map getCpuInfo() throws InterruptedException{
        Map map = new LinkedHashMap();

        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
                - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
                - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
                - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
                - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()]
                - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
                - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
                - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        //cpu核数
        int count =  processor.getLogicalProcessorCount();
        //cpu系统使用率
        String sysUsage =  new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu);
        //cpu用户使用率
        String userUsage =  new DecimalFormat("#.##%").format(user * 1.0 / totalCpu);
        //cpu当前等待率
        String waitUsage =  new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu);
        //cpu当前空闲率
        String freeUsage =  new DecimalFormat("#.##%").format(idle * 1.0 / totalCpu);
        map.put("核数",count);
        map.put("系统使用率",sysUsage);
        map.put("用户使用率",userUsage);
        map.put("当前等待率",waitUsage);
        map.put("当前空闲率",freeUsage);
        return map;
    }
    public Map getDdrInfo(){
        Map map = new LinkedHashMap();
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        // 椎内存使用情况
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();

        // 初始的总内存
        long initTotalMemorySize = memoryUsage.getInit();
        // 最大可用内存
        long maxMemorySize = memoryUsage.getMax();
        // 已使用的内存
        long usedMemorySize = memoryUsage.getUsed();
        // 操作系统
        String osName = System.getProperty("os.name");
        // 总的物理内存
        String totalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 剩余的物理内存
        String freePhysicalMemorySize = new DecimalFormat("#.##")
                .format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 已使用的物理内存
        String usedMemory = new DecimalFormat("#.##").format(
                (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024)
                + "G";
        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {

        }
        int totalThread = parentThread.activeCount();
        //内存使用率
        String usage = new DecimalFormat("#.##%").format((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) * 1.0 / osmxb.getTotalPhysicalMemorySize());


        System.err.println("操作系统:" + osName);
        System.err.println("程序启动时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(ManagementFactory.getRuntimeMXBean().getStartTime())));
        System.err.println("pid:" + System.getProperty("PID"));
        System.err.println("cpu核数:" + Runtime.getRuntime().availableProcessors());
        System.err.println("JAVA_HOME:" + System.getProperty("java.home"));
        System.err.println("JAVA_VERSION:" + System.getProperty("java.version"));
        System.err.println("USER_HOME:" + System.getProperty("user.home"));
        System.err.println("USER_NAME:" + System.getProperty("user.name"));
        System.err.println("初始的总内存(JVM):"
                + new DecimalFormat("#.#").format(initTotalMemorySize * 1.0 / 1024 / 1024) + "M");
        System.err.println(
                "最大可用内存(JVM):" + new DecimalFormat("#.#").format(maxMemorySize * 1.0 / 1024 / 1024) + "M");
        System.err.println(
                "已使用的内存(JVM):" + new DecimalFormat("#.#").format(usedMemorySize * 1.0 / 1024 / 1024) + "M");
        System.err.println("总的物理内存:" + totalMemorySize);

        System.err.println("剩余的物理内存:" + freePhysicalMemorySize);

        System.err.println("已使用的物理内存:" + usedMemory);

        System.err.println("总线程数:" + totalThread);
        map.put("总内存",totalMemorySize);
        map.put("已用内存",usedMemory);
        map.put("剩余内存",freePhysicalMemorySize);
        map.put("线程总数",totalThread);
        map.put("使用率",usage);
        return map;
    }
    public List getDiskInfo(){
        List list = new ArrayList();
        // 磁盘使用情况
        File[] files = File.listRoots();
        for (File file : files) {
            Map map = new LinkedHashMap();
            String total = new DecimalFormat("#.#").format(file.getTotalSpace() * 1.0 / 1024 / 1024 / 1024)
                    + "G";

            String free = new DecimalFormat("#.#").format(file.getFreeSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
//            String un = new DecimalFormat("#.#").format(file.getUsableSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String path = file.getPath();;
            String use = new DecimalFormat("#.#").format((file.getTotalSpace() - file.getFreeSpace()) * 1.0 /1024/1024/1024) + "G";
            String usage = new DecimalFormat("#.##%").format((file.getTotalSpace() - file.getFreeSpace()) * 1.0 / file.getTotalSpace());
            System.err.println(path + "总:" + total + ",空闲空间:" + free + " " );
            map.put("path",path);
            map.put("total",total);
            map.put("use",use);
            map.put("free",free);
            map.put("usage",usage);
            list.add(map);
            System.out.println(free);
            System.err.println("=============================================");
        }
        return list;
    }
}
