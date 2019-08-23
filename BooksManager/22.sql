
create table tb_Students(
sno varchar(20) primary key,
sname varchar(20),
spwd varchar(20),
ssex varchar(10),
sage number(10),
stel varchar(20)
);
create table tb_Books(
book_id number(20) primary key,
book_name varchar(20),
description varchar(30),
author varchar(20),
price number(10),
publish_time date,
state number(10)
);
 
create table tb_Records(
  id number(20) primary key,
  sno varchar(20),
  book_id number(20),
  record_date date,
  back_date date,
  state number(10),
  foreign key (Sno) references tb_Students(Sno),
  foreign key (book_id) references tb_Books(book_Id)
  );

insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153033','����','12345','Ů',19,'89234567');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153034','����','12345','Ů',20,'87827494');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153035','����','12345','Ů',18,'84245232');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153036','�Ի�','12345','��',21,'87624923');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153037','����','12345','��',23,'82355343');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153038','�ɷ�','12345','��',17,'82453512');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153039','����','12345','��',19,'88776284');
insert into tb_Students(sno,sname,Spwd,Ssex,Sage,Stel) values('20153040','�ܽ�','12345','��',20,'89289085');

insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(1,'JAVA���˼��','java����֪ʶ','����',78,to_date('20120625','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(2,'��������','����淶','����',35,to_date('20151127','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(3,'Spring','Spring֪ʶ','��֪��',45,to_date('20180927','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(4,'SpringMVC','SpringMVC֪ʶ','�����',37,to_date('20090913','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(5,'Mybatis','Mybatis֪ʶ','����',46,to_date('20160809','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(6,'SSM','ssm���֪ʶ','Сħ��',28,to_date('20140101','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(7,'���ݿ�ϵͳ����','���ݿ�֪ʶ','���ӷ�',33,to_date('20091027','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(8,'��ҹ��','����֮��','��Ұ����',65,to_date('20030917','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(9,'��������','�书�ؾ�','����',49,to_date('20170627','YYYYMMDD'),1);
insert into tb_books(book_id,book_name,description,author,price,publish_time,state) 
values(10,'�����澭','�书�ؾ�','�������',49,to_date('20110627','YYYYMMDD'),1);


insert into tb_records (id,sno,book_id,record_date,back_date,state) values (1,'20153033',1,
to_date('20190727','YYYYMMDD'),to_date('20190827','YYYYMMDD'),1);
insert into tb_records (id,sno,book_id,record_date,back_date,state) values (2,'20153034',2,
to_date('20190724','YYYYMMDD'),to_date('20190824','YYYYMMDD'),1);
select * from tb_books;
select * from tb_students;
select * from tb_records;
select id,tb_books.book_id,tb_books.book_name,record_date,back_date,sno,tb_records.state 
from tb_records join tb_books on tb_books.book_id = tb_records.book_id;
delete from tb_books where book_id = -11;

