<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>善款去向</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_contributeGo.css" rel="stylesheet">
</head>
<body>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">善款去向</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <!--top-->
            <div class="goTop">
                <img src="${system.basePath}/img/mine/go01.png" alt=""/>
                <p class="goTopMask"></p>
                <div class="goTopTxt">
                    <p class="goTopTxtTitle">${smartContractExt.smartContract.name?if_exists}</p>
                    <p class="goTopTxtDel" id="${smartContractAddr?if_exists}">查看项目详情</p>
                </div>
            </div>
            <!--折叠-->
            <ul class="mui-table-view goMoneyAll">
                <li class="mui-table-view-cell mui-collapse">
                    <a class="mui-navigate-right goMoneyTxt">已筹集善款</a>
                    <p class="goMoney"><span>${smartContractExt.totalYuan?if_exists}</span>元</p>
                    <div class="mui-collapse-content">
                        <!--ul-->
                        <ul class="giftDel mui-table-view">
                            <li class="mui-table-view-cell over">
                                <span class="lf">受理渠道服务费</span>
                                <span class="rt"><span>${smartContractExt.channelFeeYuan?if_exists}</span>元</span>
                            </li>
                            <li class="mui-table-view-cell over">
                                <span class="lf">慈善基金管理费</span>
                                <span class="rt"><span>${smartContractExt.fundFeeYuan?if_exists}</span>元</span>
                            </li>
                            <li class="mui-table-view-cell over">
                                <span class="lf">实收善款</span>
                                <span class="rt"><span>${smartContractExt.validTotalYuan?if_exists}</span>元</span>
                            </li>
                        </ul>
                        <!--ul-->
                        <ul class="giftDel mui-table-view">
                            <li class="mui-table-view-cell over">
                                <span class="lf">目标善款</span>
                                <span class="rt"><span>${smartContractExt.smartContract.goalYuan?if_exists}</span>元</span>
                            </li>
                            <li class="mui-table-view-cell over">
                                <span class="lf">我的捐款</span>
                                <span class="rt"><span>${donateYuan?if_exists}</span>元</span>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
            <!--善款去向-->
            <div class="traceAll">
                <p class="traceTxt">善款去向</p>
                <!--traceDel-->
                <#if smartContractTrack.trans?? && smartContractTrack.trans?size gt 0 >
                <#list smartContractTrack.trans as tran>
                <div class="traceDel">
                    <p class="traceTime">${tran.timestampStr?if_exists}</p>
                    <!--ul,ing-->
                    <ul class="traceUl ">
                        <li>
                            <span>工程用款</span>
                            <span><span>${tran.amountStr?if_exists}</span>元</span>
                        </li>
                        <li>
                            <span>工程名称</span>
                            <span>${tran.bargainName?if_exists}</span>
                        </li>
                        <li>
                            <span>工程状态</span>
                            <span class="traceIng">${tran.status?if_exists}</span>
                        </li>
                    </ul>
                    <!--kan-->
                    <p class="traceLook" id="${tran.bargainAddr?if_exists}">查看工程详情</p>
                </div>
                </#list>
                </#if>
            </div>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/mui.min.js"></script>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>

<script>
    //    跳转
    $('.user').on('tap',function(){
        window.history.back(-1);
    });

    $('.traceAll').on('tap','.traceLook',function(){
    	  var bargainId = this.getAttribute("id");
          window.location.href="${system.basePath}/app/queryBargain?bargainId="+bargainId;
 //         window.location.href="mine_contributeRate.html";
//        window.location.href="mine_contributeRateNull.html";
    });
    $('.goTop').on('tap','.goTopTxtDel',function(){
    	var smartContractAddr = this.getAttribute("id");
        window.location.href="${system.basePath}/app/querySmartContract?smartContractAddr="+smartContractAddr;
//        window.location.href="mine_contributeGoDelEnd.html";
    });




    window.onload = function(){
        //要执行的js代码段
        var h=$('.goTop img').css('height');
        $('.goTopMask').css('height',h);

    };


    //刷新加载
    mui.init({
        pullRefresh : {
            container:'#offCanvasContentScroll',//待刷新区域标识，querySelector能定位的css选择器均可，比如：id、.class等
            up : {
                height:50,//可选.默认50.触发上拉加载拖动距离
                contentrefresh : "加载中...",//可选，正在加载状态时，上拉加载控件上显示的标题内容
                contentnomore:'没有更多数据了',//可选，请求完毕若没有更多数据时显示的提醒内容；
                callback :more //必选，刷新函offCanvasContentScroll数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
            },
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
    function more() {
        var ul, str, i;
        ul =$("#offCanvasContentScroll .traceAll");
        for (i=0; i<3; i++) {
 //           str=$('<div class="traceDel"><p class="traceTime">2017.01.01</p><ul class="traceUl "><li><span>工程用款</span><span><span>10000</span>元</span></li><li><span>工程名称</span><span>张张家村水井10座</span></li><li><span>工程状态</span><span class="traceDelay">已延期</span></li></ul><p class="traceLook">查看工程详情</p></div>');
            ul.append(str);
        }
//      this.endPullupToRefresh(true);
        this.endPullupToRefresh(false);
    }



</script>
</body>

</html>