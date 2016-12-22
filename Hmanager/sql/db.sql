create user yl identified by a;
grant connect,resource to yl;
--没有给yl用户  创建表空间的权限 不能创建表空间   
create tablespace manager_temp 
datafile 'F://oracledata//manager_temp.dbf'
size 10m autoextend on next 50m maxsize 100m 
extent management local;
 commit;
select * from punish_award pa join person p on pa.punishaward_id=p.pid
--人员表
create table person(
  pid number primary key,
  pname varchar2(30) not null,    --姓名
  idCard varchar2(30) not null,  --身份证
  phonenumber varchar2(50),      --手机号
  sex varchar2(10) check(sex in ('男','女')),  --性别
  birthday varchar2(30),         --生日
  personid references department(dpid)--部门id
  ppower varchar2(10) default '普通用户,'--权限
  address varchar2(60) default '湖南',--地址
  position varchar2(60) default '老师',--岗位
  photo varchar2(200) default 'image/not_pic.jpg'   --照片
  empdate varchar2(60),  --入职时间
)tablespace manager_temp;
select * from person;
alter table person add(empdate varchar2(60))
alter table person drop column empdate
--地址
--职务表
--入职日期
delete department where dpid=341;
commit;
--部门表
create table department(
  dpid number primary key,
  dpname varchar2(20) not null,
)tablespace manager_temp;
alter table department drop column managername
delete from department where dpid=400;
select * from department
--管理员
create table manager(
  mid number primary key,
  username varchar2(30) not null,
  pwd varchar2(30) default 'a',
  upower varchar2(10)     --权限
)tablespace manager_temp;
select * from manager
--人员工资奖惩表   人员id外键
create table punish_award(
  paid number primary key,
  pamoney varchar2(30),   --奖惩钱  
  punishaward_id references person(pid),--人员id
  moneymonth varchar2(30)    --日期
)tablespace manager_temp;
select * from punish_award where punishaward_id=141666

select * from punish_award where paid=1001
alter table punish_award add(moneymonth varchar2(30))
select * from punish_award m join person p on m.paid=1019 and m.punishaward_id=p.personid
select * from punish_award where punishaward_id=141666
--创建序列
create sequence seq_pid increment by 1 start with 141666 nomaxvalue;
create sequence seq_dpid increment by 1 start with 300 nomaxvalue;
create sequence seq_paid increment by 1 start with 999 nomaxvalue;
create sequence seq_mid increment by 1 start with 1 nomaxvalue;
--删除序列
drop sequence seq_pid;
drop sequence seq_dpid;
drop sequence seq_paid;
drop sequence seq_mid;
--删除表
drop table manager;
drop table punish_award;
drop table person;
drop table department;

--插入数据
--部门表
insert into department values (seq_dpid.nextval,'财务部','张三');
insert into department values (seq_dpid.nextval,'教务部','王哥');
select * from department;
insert into person values(seq_pid.nextval,'李华','420343199212021232','18324342354','男','1992-1-2','',300);
select * from person;

insert into punish_award values(seq_paid.nextval,'请假','-20',141666);
select * from punish_award;

insert into manager values(seq_mid.nextval,'李四','a','管理员');
select * from manager where mid=1 and pwd='a';
commit;
select * from punish_award pa join person p on p.pid=pa.punishaward_id and pid=141666
select * from person p join punish_award pa on p.pid=pa.punishaward_id and pid=141666
select * from department d join person p on d.dpid=p.personid and p.pid=141666;
select count(1) total,ceil(count(1)/10) totalPage,10 pageSize,1 currPage from person 
select * from department d inner join person p on d.dpid=p.personid;
select * from (select m.*,rownum rn from (select * from person order by 1 desc) m where 1*10>=rownum) where rn>(1-1)*10 