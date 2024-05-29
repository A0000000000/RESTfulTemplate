# RESTfulTemplate
~~*用于应付客户端转行，简历上没啥服务端项目所开发的项目*~~

## 项目内容
1. 提供了一套注册登录的功能，使用JWT作为鉴权手段
2. 提供了动态创建数据表的接口
3. 提供了创建数据表后，对该数据表进行增删改查的功能

## 技术细节
1. 注册登录使用的就是简单的用户名密码模式
2. 创建数据表需要预先登录才行，数据表的名字前面会拼接“username_”，数据表的主键要求必须是int类型的名字是id
3. 增删改查功能也需要登录，主要是依赖http的四种请求方式来实现
4. 除了登录注册，其余都需要在请求头中添加token信息

## 静态API
1. POST /user/register
    * 参数: 
      * username: String
      * password: String
2. POST /user/login
   * 参数:
     * username: String
     * password: String
   * 返回值:
     * token: String
3. POST /table/create
   * 参数: 参见Bean Table的内容

## 动态API
1. GET /template/{table}
2. GET /template/{table}/{id}
3. POST /template/{table}
4. PUT /template/{table}
5. DELETE /template/{table}/{id}