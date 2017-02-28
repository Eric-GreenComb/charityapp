<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>支付详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/pay.css" rel="stylesheet">
</head>
<body>
<!--header-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/payBack.png" alt=""/></p>
        <p class="headerTitle">慈善区块链</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <!--head-->
            <p class="payTop">云支付</p>
            <!--money-->
            <div class="payMoney">
                <p class="payHow">&yen;<span>${donorAmount?if_exists}</span></p>
                <p class="payWhere">商户：<span>瑶瑶缴费</span></p>
            </div>
            <!--ul-->
            <ul class="goods mui-table-view">
                <li class="mui-table-view-cell over">
                    <span class="lf">商品：</span>
                    <span class="rt">${smartContractExt.smartContract.name?if_exists}</span>
                </li>
                <li class="mui-table-view-cell over">
                    <span class="lf">订单：</span>
                    <span class="rt">${orderNum?if_exists}</span>
                </li>
            </ul>
            <!--银行卡-->
            <div>
                <p class="arrowTop"><img src="${system.basePath}/img/common/arrowTop.png" alt=""/></p>
                <p class="cardTxt">填写银行卡信息</p>
                <p class="cardLogo"><img src="${system.basePath}/img/common/payLogo.png" alt=""/>中国光大银行</p>
                <!--ul-->
                <ul class="cardUl mui-table-view">
                    <li class="mui-table-view-cell over">
                        <span class="lf"><label for="bankCard">银行卡号：</label></span>
                        <span class="rt"><input id="bankCard" type="number" placeholder="6626 6666 **** 678"/></span>
                    </li>
                    <li class="mui-table-view-cell over">
                        <span class="lf"><label for="userName">姓名：</label></span>
                        <span class="rt"><input id="userName" type="text" placeholder="张三"/></span>
                    </li>
                    <li class="mui-table-view-cell over">
                        <span class="lf"><label for="idNum">身份证号：</label></span>
                        <span class="rt"><input id="idNum" type="text" placeholder="11000000000000000"/></span>
                    </li>
                    <li class="mui-table-view-cell over">
                        <span class="lf"><label for="phone">手机号：</label></span>
                        <span class="rt"><input id="phone" type="text" placeholder="1560000000"/></span>
                    </li>
                    <li class="mui-table-view-cell over">
                        <span class="lf"><label for="idCode">验证码：</label></span>
                        <span class="rt idCode"><input id="idCode" type="text" placeholder=""/><span class="idCodeTxt" id="idCodeTxt"><label for="idCode">获取验证码</label></span></span>
                    </li>
                </ul>
                <!--协议-->
                <p class="mui-input-row mui-checkbox mui-left"><input type="checkbox" id="cardAgree" checked/><label for="cardAgree">我已阅读并同意<span class="bankPhone">《云支付服务协议》</span></label></p>
                <p class="confirmPay" id="confirmPay">确认支付</p>
            </div>
            <!--提示-->
            <div class="kind">
                <p>温馨提示：</p>
                <p>每笔限额1,000.00元；每日限额1,000.00元；每月限额100,000.00元。</p>
            </div>
        </div>
    </div>
</div>

<!--确认捐款mask-->
<div class="mask enterMask" id="enterMask">
    <span><img src="${system.basePath}/img/common/timg.gif" alt=""/>支付中，请稍后...</span>
</div>
<script src="${system.basePath}/js/mui.min.js"></script>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>

<script>


    // 跳转
$('#confirmPay').on('tap',function(){
    if( $('#cardAgree').prop("checked") ){
    	$('#enterMask').fadeIn();
    	var donorAmount='${donorAmount?if_exists}';
        var smartContractAddr='${smartContractAddr?if_exists}';
       	window.location.href="${system.basePath}/app/donate?donorAmount="+donorAmount+"&smartContractAddr="+smartContractAddr+"&tm="+new Date().getTime() ;
       // window.location.href="payOK.html";
    }else{
        mui.alert("必须同意《云支付服务协议》")
    }
});
$('.user').on('tap',function(){
    window.history.back(-1);
});


    //刷新加载
    mui.init({
        pullRefresh : {
            container:'#offCanvasContentScroll',//待刷新区域标识，querySelector能定位的css选择器均可，比如：id、.class等

            down : {
                height:50,//可选,默认50.触发下拉刷新拖动距离,
                contentdown : "下拉刷新",//可选，在下拉可刷新状态时，下拉刷新控件上显示的标题内容
                contentover : "释放刷新",//可选，在释放可刷新状态时，下拉刷新控件上显示的标题内容
                contentrefresh : "加载中...",//可选，正在刷新状态时，下拉刷新控件上显示的标题内容
                callback :pullLi1 //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
            }
        }
    });

    function pullLi1(){
        window.location.reload();
        mui('#offCanvasContentScroll').pullRefresh().endPulldownToRefresh();
    }

</script>
</body>

</html>