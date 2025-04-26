
# 尚庭公寓租赁平台

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 🏠 项目简介

尚庭公寓是一个现代化的公寓租赁平台，包含：
- **后台管理系统**：面向管理员，提供房源管理、租赁管理、用户管理等功能
- **移动端应用**：面向租客，提供房源检索、看房预约、租约管理等功能

## ✨ 功能特性

### 后台管理系统
- 🏢 公寓信息管理（CRUD）
- 🛏️ 房间信息管理
- 📅 看房预约管理
- 📝 租约管理（签约/续约/退租）
- 👥 用户管理
- ⚙️ 系统设置

### 移动端
- ?? 智能房源检索
- 📅 在线看房预约
- 📱 租约电子化管理
- ⏳ 浏览历史记录

## 🛠️ 技术栈

### 前端技术
- **框架**: Vue 3 + Vite
- **UI组件**: Element Plus
- **状态管理**: Pinia
- **路由**: Vue Router
- **可视化**: ECharts
- **构建工具**: Vite

### 后端技术
- **核心框架**: Spring Boot
- **ORM**: MyBatis-Plus
- **数据库**: MySQL
- **缓存**: Redis
- **对象存储**: MinIO
- **API文档**: Knife4j

## 🚀 快速开始

### 开发环境准备
1. 安装 Node.js (v16+)
2. 安装 Java JDK (v11+)
3. 安装 MySQL (v8.0+)
4. 安装 Redis (v6.0+)

### 前端启动
```bash
cd lease-Admin
npm install
npm run dev
```

### 后端启动
1. 导入项目到IDE
2. 配置数据库连接
3. 启动主应用类

## 🛠️ 开发指南

### 项目结构
```
lease-master/
├── lease-Admin/       # 前端项目
├── lease-web/         # 后端服务
├── lease-common/      # 公共模块
├── lease-model/       # 数据模型
└── lease-HouseH5/     # 移动端H5
```

### API规范
- 遵循RESTful设计规范
- 统一响应格式
- JWT认证

## 📦 部署说明

### 生产环境要求
- Linux服务器
- Nginx (前端部署)
- Docker (可选)

### 部署步骤
1. 前端构建
```bash
npm run build
```
2. 后端打包
3. 配置Nginx反向代理

## 🤝 贡献指南

欢迎提交Pull Request，请遵循以下规范：
1. Fork项目
2. 创建特性分支
3. 提交清晰的commit信息
4. 推送分支并创建Pull Request

## 📄 许可证

MIT License © 2023 尚庭公寓团队
