关系数据库
1.交易跟区块链 txid的对应关系和对应区块的高度，需要记录
2.合同的相关信息
3.用户表中需要关联 id和 cc donoraddress
4.基金的信息表，基金对应合约id，逗号分隔形式存储
5.基金账本的流水记录，捐款和提款的记录

	
drop table if exists sys_trans_rel;

/*==============================================================*/
/* Table: sys_trans_rel                                         */
/*==============================================================*/
create table sys_trans_rel
(
   trans_id             varchar(100),
   txid                 varchar(100),
   block_height         varchar(10),
   trans_sign           varchar(200),
   contract_id          varchar(100)
);

alter table sys_trans_rel comment '交易跟区块链 txid的对应关系和对应区块的高度，需要记录';


drop table if exists sys_bargain;

/*==============================================================*/
/* Table: sys_bargain                                           */
/*==============================================================*/
create table sys_bargain
(
   bargain_id           varchar(100),
   addr                 varchar(100),
   attach               varchar(100)
);

alter table sys_bargain comment '合同信息表';


drop table if exists sys_fund_flow;

/*==============================================================*/
/* Table: sys_fund_flow                                         */
/*==============================================================*/
create table sys_fund_flow
(
   flow_id              varchar(10),
   trans_id             varchar(20),
   type                 varchar(10),
   trans_time           varchar(20),
   contract_id          varchar(20),
   contract_name        varchar(20),
   amount               varchar(20)
);

alter table sys_fund_flow comment '流水表';


drop table if exists sys_fund;

/*==============================================================*/
/* Table: sys_fund                                              */
/*==============================================================*/
create table sys_fund
(
   fund_id              varchar(100),
   addr                 varchar(100),
   contrats             varchar(200)
);


drop table if exists sys_contract;

/*==============================================================*/
/* Table: sys_contract                                          */
/*==============================================================*/
create table sys_contract
(
   id                   varchar(100),
   addr                 varchar(100)
);

drop table if exists sys_user;

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   name                 varchar(50),
   password             varchar(50),
   addr                 varchar(100),
   type                 varchar(10)
);


