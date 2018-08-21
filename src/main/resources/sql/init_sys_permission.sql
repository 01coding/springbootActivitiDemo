-- -------- 权限表 --------
drop table if exists t_permission;
create table t_permission(
    pid int(11) not null auto_increment COMMENT '权限主键ID',
    pname varchar(255) not null default '' COMMENT '权限名称',
    url varchar(255) not null default '' COMMENT '权限URL',
    primary key(pid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '系统权限表';

insert into t_permission(pid, pname) values (1, 'add');
insert into t_permission(pid, pname) values (2, 'delete');
insert into t_permission(pid, pname) values (3, 'edit');
insert into t_permission(pid, pname) values (4, 'query');

-- --------- 用户表 ----------
drop table if exists t_user;
create table t_user(
    uid int(11) not null auto_increment COMMENT '用户主键ID',
    username varchar(255) not null default '' COMMENT '用户名',
    password varchar(255) not null default '' COMMENT '密码',
    primary key(uid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '系统用户表';

insert into t_user values (1, 'admin' , '123');
insert into t_user values (2, 'demo' , '123');

-- --------- 角色表 ----------
drop table if exists t_role;
create table t_role(
    rid int(11) not null auto_increment COMMENT '角色主键ID',
    rname varchar(255) not null default '' COMMENT '角色名称',
    primary key(rid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '系统角色表';

insert into t_role values (1, 'admin');
insert into t_role values (2, 'customer');


-- --------- 权限与角色关系表 ----------
drop table if exists t_permission_role;
create table t_permission_role(
    rid int(11) not null COMMENT '角色主键ID',
    pid int(11) not null COMMENT '权限主键ID',
    key idx_pid(pid),
    key idx_rid(rid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '权限与角色关系表';


insert into t_permission_role values (1, 1);
insert into t_permission_role values (1, 2);
insert into t_permission_role values (1, 3);
insert into t_permission_role values (1, 4);
insert into t_permission_role values (2, 1);
insert into t_permission_role values (2, 4);


-- --------- 用户与角色关系表 ----------
drop table if exists t_user_role;
create table t_user_role(
    uid int(11) not null COMMENT '用户主键ID',
    rid int(11) not null COMMENT '角色主键ID',
    key idx_uid(uid),
    key idx_rid(rid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '用户与角色关系表';

insert into t_user_role values (1, 1);
insert into t_user_role values (2, 2);

