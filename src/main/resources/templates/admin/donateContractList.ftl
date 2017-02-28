<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>捐款合约---合约列表</title>
    <link rel="stylesheet" href="${system.basePath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${system.basePath}/css/bootstrap-select.css">
    <link rel="stylesheet" href="${system.basePath}/css/dateSelect.css">
    <link rel="stylesheet" href="${system.basePath}/css/common_admin.css"/>
</head>
<body>

<!--提款详情-->
<div class="dealDel">
    <div class="maskAll">
        <div class="dealMask">
            <p class="dealTitle">合约详情<img src="${system.basePath}/img/common_admin/closeIcon.png" class="rt close" alt=""/></p>
            <p class="maskColor"></p>
            <ul class="maskUl">
                <li><p>时间：<span>2016.01.08  18:21</span></p></li>
                <li><p>状态：<span class="mineStatus">成功</span></p></li>
                <li><p>施工合同名称：<span>宁夏母亲水窖项目-张家村水井10座</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>捐款人：<span>母亲水窖基金</span></p></li>
                <li><p>收款人：<span>**建筑公司</span></p></li>
                <li><p>提款金额：<span>1000</span></p></li>
            </ul>
            <ul class="maskUl">
                <li><p>流水号（哈希）：<span>0000000000909</span></p></li>
                <li><p>施工合同ID：<span>300001</span></p></li>
            </ul>
            <div class="maskUl">
                <p>备注信息</p>
                <p class="remark">项目一期尾款。</p>
            </div>
            <p class="backBtn"><button>返回</button></p>
        </div>
    </div>
</div>


<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_admin/logo.png" alt=""/>
            <span class="logoTxt">公益捐款 <span class="logoTxtSm">基金会版</span></span>
        </div>
        <div class="rt logoTxtSmRt">
            <p>欢迎您！中国妇女基金会母亲水窖基金委员会</p>
        </div>
        <div class="logoTxtSmRt logoAct">
            <p><img src="${system.basePath}/img/common_admin/tkIcon.png" alt=""/>提款</p>
            <p><img src="${system.basePath}/img/common_admin/tcIcon.png" alt=""/>退出</p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <!--lf-->
        <ul class="lf secLf">
             <li><a href="${system.basePath}/admin/index" ><img src="${system.basePath}/img/common_admin/accountIcon.png" alt=""/><span>账户概览</span></a></li>
            <li><a href="${system.basePath}/admin/myAccountBook" ><img src="${system.basePath}/img/common_admin/mineIcon.png" alt=""/><span>我的账本</span></a></li>
            <li><a href="${system.basePath}/admin/donateContractList" class="curIcon"><img src="${system.basePath}/img/common_admin/contributeIcon.png" alt=""/><span>捐献合约</span></a></li>
            <li><a href="${system.basePath}/admin/bargainItemList"><img src="${system.basePath}/img/common_admin/contractIcon.png" alt=""/><span>施工合同</span></a></li>
            
        </ul>
        <!--rt-->
        <div class="rt secRt">
            <!--账本详情-->
            <div class="accountBook">
                <p class="lf accTxt conList">合约列表 &gt; <span>宁夏母亲水窖合约账本详情</span></p>
                <p class="rt"><span>账户余额</span><span class="accMoney">999,999,999.00 &yen;</span></p>
            </div>
            <!--选择-->
            <div class="choose">
                <form action="">
                    <select id="type" class="selectpicker show-tick form-control">
                        <option>选择类型</option>
                        <option>捐款</option>
                        <option>提款</option>
                    </select>
                    <div class="timeKuang">
                        <input type="text" id="date" placeholder="选择时间">
                    </div>
                </form>
            </div>
            <!--del-->
            <ul class="mineDel">
                <li class="mineTitle">
                    <span class="mineType">类型</span>
                    <span class="mineTime">时间</span>
                    <span class="mineMoney">金额</span>
                    <span class="mineContract">所属合约</span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney addMon">+ 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney minusMon">- 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney addMon">+ 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney minusMon">- 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney addMon">+ 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney minusMon">- 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney addMon">+ 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
                <li class="mineInfo">
                    <span class="mineType">捐款</span>
                    <span class="mineTime">2016.01.10 18:00</span>
                    <span class="mineMoney minusMon">- 2,016.00</span>
                    <span class="mineContract">宁夏母亲水窖</span>
                    <span class="rt delIcon"><img src="${system.basePath}/img/common_admin/delIcon.png" alt=""/></span>
                </li>
            </ul>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/admin/dateSelectList.js"></script>
<script src="${system.basePath}/js/bootstrap.js"></script>
<script src="${system.basePath}/js/admin/bootstrap-select.js"></script>
<script src="${system.basePath}/js/admin/common_admin.js"></script>
<script>
    $('.delIcon').click(function(){
        $('.dealDel').fadeIn();
    });
    $('.close').click(function(){
        $('.dealDel').fadeOut();
    });
    $('.backBtn button').click(function(){
        $('.dealDel').fadeOut();
    });

    //    时间
    $("#date").dateSelect();
</script>
</body>
</html>