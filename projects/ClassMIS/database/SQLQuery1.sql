--�༶��Ϣ����Сmisϵͳ
--���༶
create table class(
no nvarchar(50) not null,	--��ţ�������
name nvarchar(50),			--����
primary key(no)
);
--���γ�
create table course(
no nvarchar(50) not null,	--��ţ�������
name nvarchar(50),			--����
nature nvarchar(50),		--�γ�����
credit nvarchar(50),		--ѧ��
primary key(no)
);
--��ѧ��
create table student(
no nvarchar(50) not null,	--ѧ�ţ�������
name nvarchar(50),			--����
sex nvarchar(50),			--�Ա�
brithday nvarchar(50),		--��������
password nvarchar(50),		--����
phone nvarchar(50),			--��ϵ�绰
adress nvarchar(50),		--��ͥסַ
classno nvarchar(50),		--�༶��ţ������
foreign key(classno) references class(no),
primary key(no)
);
--���ɼ�
create table grade(
studentno nvarchar(50) not null,	--ѧ�ţ������������
courseno nvarchar(50) not null,		--�γ̱�ţ������������
grade int default(0) check(grade>=0 and grade<=100),	--�ɼ���0-100��
foreign key(studentno) references student(no),
foreign key(courseno) references course(no),
primary key(studentno,courseno)
);