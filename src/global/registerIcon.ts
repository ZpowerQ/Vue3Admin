import { App } from 'vue'
import {
  ArrowDown,
  Avatar,
  Compass,
  Expand,
  Fold,
  Goods,
  HelpFilled,
  Iphone,
  Key,
  Menu,
  Monitor,
  PieChart,
  Search,
  Service,
  Setting,
  Shop,
  ShoppingBag,
  User,
  UserFilled,
  Bell
} from '@element-plus/icons'

const components = [
  User,
  Iphone,
  Menu,
  Setting,
  Shop,
  Monitor,
  HelpFilled,
  Key,
  PieChart,
  UserFilled,
  Compass,
  Avatar,
  ShoppingBag,
  Goods,
  Service,
  Fold,
  Expand,
  ArrowDown,
  Search,
  Bell
]

export default function (app: App): void {
  for (const component of components) {
    app.component(component.name, component)
  }
}
