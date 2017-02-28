<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>支付成功</title>
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
            <!--payok-->
            <div class="payOK">
                <dl class="payMeg">
                    <dt><img src="${system.basePath}/img/common/payOK.png" alt=""/></dt>
                    <dd>支付成功！</dd>
                </dl>
                <p class="confirmPay" id="backToIndex"><span id="backToIndexSecond">5</span>秒自动返回商户页面</p>
                <p class="yunLogo"><img src="${system.basePath}/img/common/yunLogo.png" alt=""/></p>
                <p class="bankImg">本服务由中国光大银行（www.cebbank.com）提供</p>
                <p class="bankImg">中国光大银行客户服务电话：<span class="bankPhone">95595</span></p>
            </div>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/mui.min.js"></script>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>

<script>

    //    // 跳转
        $('#backToIndex').on('tap',function(){
            //window.location.href="index.html";
            var donorid ='${donorid?if_exists}';
            	window.location.href="${system.basePath}/app/donateInfo?donorid="+donorid+"&tm="+new Date().getTime() ;
        });
        $('.user').on('tap',function(){
            window.history.back(-1);
        });
        
        //完成订单
     function redirIndex()
    {
    		var backToIndexSecond =$("#backToIndexSecond").html();
    		if(parseInt(backToIndexSecond)>0){
    			backToIndexSecond=parseInt(backToIndexSecond)-1;
    			$("#backToIndexSecond").html(backToIndexSecond);
				setTimeout("redirIndex()",1000);
    		}else{
    			  var donorid ='${donorid?if_exists}';
    			window.location.href="${system.basePath}/app/donateInfo?donorid="+donorid+"&tm="+new Date().getTime() ;
    		}
    		
    }
    redirIndex();
        
        

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