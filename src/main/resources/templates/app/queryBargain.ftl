<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>工程进度</title>
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
        <p class="headerTitle">工程进度</p>
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
                    <p class="goTopTxtTitle">宁夏母亲水窖项目</p>
                    <p class="traceP"><span class="traceEnd">已验收</span></p>
                    <!--<p class="traceP"><span class="traceIng">进行中</span></p>-->
                    <!--<p class="traceP"><span class="traceDelay">已延期</span></p>-->
                </div>
            </div>
            <!--icon-->
            <div class="rateIcon mui-row">
                <p class="mui-col-xs-3 rateHT">
                    <img src="${system.basePath}/img/common/rate_htIcon.png" alt=""/>
                    <span>工程合同</span>
                </p>
                <p class="mui-col-xs-3 rateIMGS">
                    <img src="${system.basePath}/img/common/rate_sgIcon.png" alt=""/>
                    <span>施工图集</span>
                </p>
                <p class="mui-col-xs-3 rateJL">
                    <img src="${system.basePath}/img/common/rate_tkIcon.png" alt=""/>
                    <span>提款记录</span>
                </p>
                <p class="mui-col-xs-3 rateBG">
                    <img src="${system.basePath}/img/common/rate_ysIcon.png" alt=""/>
                    <span>验收报告</span>
                </p>
            </div>
            <!--项目动态-->
            <div class="dynamicAll">
                <p class="readZi"><span>项目动态</span></p>
                <!--del-->
                <div class="dynamicCon">
                    <!--yi-->
                    <div class="mui-row dynamicYi">
                        <div class="mui-col-xs-2">
                            <p class="yue"><span>12</span>月</p>
                            <p class="ri"><span>01</span>日</p>
                        </div>
                        <ul class="mui-col-xs-10 dynamicUl">
                           <li><p>项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述</p></li>
                           <li><img src="${system.basePath}/img/mine/dt01.png" alt=""/></li>
                           <li><img src="${system.basePath}/img/mine/dt02.png" alt="" /></li>
                        </ul>
                    </div>
                    <!--yi-->
                    <div class="mui-row dynamicYi">
                        <div class="mui-col-xs-2">
                            <p class="yue"><span>12</span>月</p>
                            <p class="ri"><span>01</span>日</p>
                        </div>
                        <ul class="mui-col-xs-10 dynamicUl">
                            <li><p>项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述</p></li>
                            <li><img src="${system.basePath}/img/mine/dt01.png" alt="" /></li>
                            <li><img src="${system.basePath}/img/mine/dt02.png" alt=""/></li>
                        </ul>
                    </div>
                </div>
            </div>
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

    $('.rateHT').on('tap',function(){
    	// window.location.href="mine_contributeRate_contract.html";
        window.location.href="${system.basePath}/app/queryBargainContract";
    });
    $('.rateIMGS').on('tap',function(){
        //window.location.href="mine_contributeRate_imgs.html";
        window.location.href="${system.basePath}/app/queryBargainImages";
    });
    $('.rateJL').on('tap',function(){
        //window.location.href="mine_contributeRate_drawing.html";
        window.location.href="${system.basePath}/app/queryBargainDraw";
    });
    $('.rateBG').on('tap',function(){
       // window.location.href="mine_contributeRate_contract.html";
        window.location.href="${system.basePath}/app/queryBargainCheck";
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
        ul =$("#offCanvasContentScroll .dynamicAll");
        for (i=0; i<3; i++) {
            str=$('<div class="mui-row dynamicYi"><div class="mui-col-xs-2"><p class="yue"><span>12</span>月</p><p class="ri"><span>01</span>日</p></div><ul class="mui-col-xs-10 dynamicUl"><li><p>项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述项目进展描述</p></li><li><img src="${system.basePath}/img/mine/dt01.png" alt="" /></li><li><img src="${system.basePath}/img/mine/dt02.png" alt=""/></li></ul></div>');
            ul.append(str);
        }
//      this.endPullupToRefresh(true);
        this.endPullupToRefresh(false);
    }



</script>
</body>

</html>