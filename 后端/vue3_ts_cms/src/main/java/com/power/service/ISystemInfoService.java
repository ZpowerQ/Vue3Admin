package com.power.service;

import java.util.List;
import java.util.Map;

public interface ISystemInfoService {
    public Map getCpuInfo();
    public Map getDdrInfo();
    public List getDiskInfo();
}
