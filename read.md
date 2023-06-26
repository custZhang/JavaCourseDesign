更改jdbc.properties里的配置就可以使用了。
运行时有时req.getParameter("deleteFName");会获取乱码，改为WebUtils.readString(req,"deleteFName")就行了