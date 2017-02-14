关系数据库
1.交易跟区块链 txid的对应关系和对应区块的高度，需要记录
2.合同的相关信息
3.用户表中需要关联 id和 cc donoraddress
4.基金的信息表，基金对应合约id，逗号分隔形式存储
5.基金账本的流水记录，捐款和提款的记录


	drop table  if exists sys_bargain;
CREATE TABLE sys_bargain (
	id    varchar(100),
	name  varchar(100), 
	addr  varchar(100), 
	detail  varchar(500), 
	startTime  varchar(20), 
	endTime    varchar(20), 
	partyA     varchar(100), 
	partyB     varchar(100), 
	depositBank     varchar(100), 
	bankAccount     varchar(100), 
	status     char(1), 
	remark  varchar(500)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
    drop table  if exists user;
CREATE TABLE user (
	name varchar(100),
	age varchar(20), 
	password varchar(100)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;