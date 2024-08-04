### 静态文件生成：
[StaticGenerator.java](generator/StaticGenerator.java)
### 动态文件生成：
[DynamicGenerator.java](generator/DynamicGenerator.java)
### 最终：动静太文件生成
1、先拷贝源文件（文件夹及文件）
2、根据 模板 覆盖 对应文件
[MainGenerator.java](generator/MainGenerator.java)

#### 动态文件 模板对象（即 对应 模板坑 中要填的值）
[MainTemplateConfig.java](model/MainTemplateConfig.java)

#### 存放模板文件
src/main/resources/templates
