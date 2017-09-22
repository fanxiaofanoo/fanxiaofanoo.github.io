--班级信息管理小mis系统
--表：班级
create table class(
no nvarchar(50) not null,	--编号（主键）
name nvarchar(50),			--名称
primary key(no)
);
--表：课程
create table course(
no nvarchar(50) not null,	--编号（主键）
name nvarchar(50),			--名称
nature nvarchar(50),		--课程性质
credit nvarchar(50),		--学分
primary key(no)
);
--表：学生
create table student(
no nvarchar(50) not null,	--学号（主键）
name nvarchar(50),			--姓名
sex nvarchar(50),			--性别
brithday nvarchar(50),		--出生日期
password nvarchar(50),		--密码
phone nvarchar(50),			--联系电话
adress nvarchar(50),		--家庭住址
classno nvarchar(50),		--班级编号（外键）
foreign key(classno) references class(no),
primary key(no)
);
--表：成绩
create table grade(
studentno nvarchar(50) not null,	--学号（主键，外键）
courseno nvarchar(50) not null,		--课程编号（主键，外键）
grade int default(0) check(grade>=0 and grade<=100),	--成绩（0-100）
foreign key(studentno) references student(no),
foreign key(courseno) references course(no),
primary key(studentno,courseno)
);