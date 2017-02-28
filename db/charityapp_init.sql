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


delete from sys_bargain;
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain01', 'bargain01:8fcc58ea7ed212f7c1ba359d15bea144e67c390044d953797548cf67fd62534a', null, '工程1');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain02', 'bargain02:527b016abdea151f014f3fd2f840f5a02b66ebde6ffc4172d2b2e50b4c46c423', null, '工程2');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain03', 'bargain03:83a9c5019541d6b8f9170bfd59e79b77a217e3cab2989d6db706b0e08240ebb3', null, '工程3');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain04', 'bargain04:6a9eae00ae31d44ae7ad40cf2a66d7eee85ae624a1a737581fa7ddcf1dd20230', null, '工程4');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain05', 'bargain05:0723e1bcdf3ec08dd94a83f50aab1114dc420c215fb869ae518ec755c320dab1', null, '工程5');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain06', 'bargain06:990490e80e68525fc7c8cf276adec3087c261876f85934e7e553eaf0071ccb4f', null, '工程6');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain07', 'bargain07:765b5cf305978f41ec5a59e854f7b3f5eaa5a3889fd6b1c387f9447a2608d921', null, '工程7');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain08', 'bargain08:ea218af5f53e8e6ff824caab6fc521b5fa01fbce3525a46aa456cb63c884a522', null, '工程8');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain09', 'bargain09:0fb2a0cdddddcfa33052c81b5e8ebbb05da19b69880487a49f44d2cfb37a7773', null, '工程9');
INSERT INTO sys_bargain (id, addr, attach, name) VALUES ('bargain10', 'bargain10:9d681edb9d219cbb9885cc49d9bf76060febfa5e404e8c3a3fc269753250b62d', null, '工程10');

delete from sys_contract;
INSERT INTO sys_contract (id, addr, pic, detail) VALUES ('smartcontract01', 'smartcontract01:1d54a8713923af1718e8eeabec3e4d8596dbbdf2da3f69ea23aeb8c7a5ab73d8', 'img/index/news01.png', null);
INSERT INTO sys_contract (id, addr, pic, detail) VALUES ('smartcontract02', 'smartcontract02:f14e694150c33750690d2c3baad7bb3406799263f7de5920a088072da5797800', 'img/index/news02.png', null);
INSERT INTO sys_contract (id, addr, pic, detail) VALUES ('smartcontract03', 'smartcontract03:9564142592ce9c66edb005f8098a725f72325d8a0411028ab78911f5d6c14718', 'img/index/news01.png', null);
INSERT INTO sys_contract (id, addr, pic, detail) VALUES ('smartcontract04', 'smartcontract04:facd57477f723c07a85296c20f53ebad70c8ac4edbd67094ea3121bc8d1e8994', 'img/index/news02.png', null);
INSERT INTO sys_contract (id, addr, pic, detail) VALUES ('smartcontract05', 'smartcontract05:5e8f644f5d79ad3d515f86ac545bf665595c9558e236b3c87965d4ff122a8286', 'img/index/news01.png', null);

delete from sys_foundation;
INSERT INTO sys_foundation (id, addr, contrats) VALUES ('fund01', 'fund01:25ab580a2093776ca2e1dd1775e96dfec5f1ffbcc9565129351cb330cf0712d7  ', 'smartcontract01');

delete from sys_user;
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('channel01', '瑶瑶缴费', '1234', 'channel01:9c8b43ce948010efc3b7d102aae502165ccd5e0714a3e765fe1a8f444936785a', 'channel');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor01', '测试用户', '1234', 'donor01:275e74b0e340f54135496e46d829b25af699984e6787f9a7b13191ad991a1eb1', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor02', '测试用户2', '1234', 'donor02:b931578857dbe9cb37d0e59cd9cc5fb3758758d0cee1e905e25fe62f9e9e2688', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor03', '测试用户3', '1234', 'donor03:a65557075090886383f6c67220e22b095dcfe1f3a6fcb47f6fb622a3ce0f1c2d', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor04', '测试用户4', '1234', 'donor04:55e79613ab432a03a9c894e3efbbe5d3f0a445feea82ff49c98cb03302ea6541', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor05', '测试用户5', '1234', 'donor05:f799bc349d140248bb1ea2bd1f9a820ae99161b9bc59c0ac212f6d276e9a2468', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor06', '测试用户6', '1234', 'donor06:293db3e941705aaabe9505e4a513ceac8b51b8ae1407c28b7eb8ff88193eb2f6', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor07', '测试用户7', '1234', 'donor07:0abc5a0def68504b23bd4fafde9fa089315f60ae6077535643ee6705643115f1', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor08', '测试用户8', '1234', 'donor08:dc0e0c13816ba9270f23fb67338c21e68459dc977c85dc8ef7f4eff0e5df6189', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor09', '测试用户9', '1234', 'donor09:e98462be3aebacb5bf8acf6b0d3ef46331016b4263b787a0867dea25613fb6ae', 'user');
INSERT INTO sys_user (id, name, password, addr, type) VALUES ('donor10', '测试用户10', '1234', 'donor10:79289520e19c9d80ca228d22ca2c11dc775348cdfece34cfc32f99dd5ef89243', 'user');



