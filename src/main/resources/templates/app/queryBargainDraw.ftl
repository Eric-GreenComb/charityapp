<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>提款明细</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_contributeGo.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_contributeRate.css" rel="stylesheet">
</head>
<body>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">提款明细</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <div class="drawingAll">
                <p class="drawingTxt">累计提款</p>
                <#if bargainTrack.totalStr?if_exists?? && bargainTrack.totalStr?if_exists != ''>
                <p class="drawingMon"><span>${bargainTrack.totalStr?if_exists}</span>元</p>
                <#else>
                <p class="drawingMon"><span>0</span>元</p>
                </#if>
            </div>
            <!--ul-->
            <ul class="drawingDel">
               <#list bargainTrack.trans as track>
               		 <li class="over">
	                   <p class="lf">${track.timestampStr?if_exists?substring(0,10)}</p>
	                   <p class="rt"><span>${track.amountStr?if_exists}</span>元</p>
               		 </li>
               </#list>
            </ul>
        </div>
    </div>
</div>

<script src="${system.basePath}/js/mui.min.js"></script>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>

<script>

    //跳转
    $('.user').on('tap',function(){
        window.history.back(-1);
    });
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
        ul =$("#offCanvasContentScroll .drawingDel");
        for (i=0; i<3; i++) {
            str=$('<li class="over"><p class="lf">2016.12.1</p><p class="rt"><span>10000.00</span>元</p></li>');
            ul.append(str);
        }
//      this.endPullupToRefresh(true);
        this.endPullupToRefresh(false);
    }



</script>
</body>

</html>