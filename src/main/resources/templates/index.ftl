<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <link rel="stylesheet" href="css/mui.min.css"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/index.css" rel="stylesheet"/>
</head>
<body>

<!--mask-->
<div class="mask indexQuit">
    <div class="indexMaskAll">
        <div class="indexMask">
            <p class="indexInfo">用户信息</p>
            <p class="curUser">当前登录用户为 <span>${userName?if_exists}</span></p>
            <p class="indexAct"><span class="indexActQuit">退出登录</span><span class="indexActKnow">我知道了</span></p>
        </div>
    </div>
</div>

<!--head-->
<div class="headerIndex">
    <!--微公益-->
    <div class="headerTopRen">
        <!--<p class="userRen">用户<span>138****0921</span></p>-->
        <p class="headerTitleRen">微公益</p>
        <p class="quitIndex"><img src="img/common/quitIndexIcon.png" alt=""/></p>
    </div>
</div>

<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <!--head-->
            <div >
                <!--tree-->
                <div class="headerTree">
                    <div class="headerTreeCon">
                        <div class="tree over">
                            <p class="lf"><img src="img/index/treeIcon.png" alt="" class="treeIcon"/></p>
                            <div class="rt">
                                <p class="allGift">我已捐赠善款</p>
                                <p class="allMoney"><span>${user.totalStr}</span>元</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!--捐款-->
                <div class="mine mui-row">
                    <dl class="mui-col-xs-6" id="gift" >
                        <dt><img src="img/index/giftIcon.png" alt="" /></dt>
                        <dd>捐款记录</dd>
                        
                    </dl>
                    <dl class="mui-col-xs-6" id="contribute" >
                        <dt><img src="img/index/traceIcon.png" alt=""/></dt>
                        <dd>善款追踪</dd>
                    </dl>
                </div>
            </div>
            <!--news-->
            <div class="newsCon">
                <p class="newsIcon"><img src="img/index/newsIcon.png" alt="" class=""/>筹款中的公益项目</p>
                <ul class="newsAll mui-table-view">
                
                	<#list smartcontracts as smt>
						 <li class="mui-table-view-cell mui-row" id="${smt.addr?if_exists}">
	                        <div class="mui-col-xs-4 newsMask">
	                            <img src="${smt.pic?if_exists}" alt="" class="img-responsive maskPic"/>
	                            <p class="maskImg"></p>
	                            <p class="maskTxt">共<span>${smt.donateNumber?if_exists}</span>份爱心</p>
	                        </div>
	                        <div class="mui-col-xs-7 newsDel">
	                            <p class="newsTitle">${smt.smartContract.name?if_exists}</p>
	                            <p class="newsTxt">${smt.smartContract.detail?if_exists}</p>
	                            <div class="newsMoney">
	                                <#if smt.totalStr?? && smt.totalStr != ''>
	                                <p>已筹<span>${smt.totalStr?if_exists}</span>万元</p>
	                                <#else>
	                                <p>已筹<span>0</span>万元</p>
	                                </#if>
	                                <#if smt.smartContract.goalStr?? && smt.smartContract.goalStr != ''>
	                                <p>目标<span>${smt.smartContract.goalStr?if_exists}</span>万元</p>
	                                <#else>
	                                <p>目标<span>0</span>万元</p>
	                                </#if>
	                            </div>
	                        </div>
	                        <div class="mui-col-xs-1 newsImg">
	                            <img src="img/index/per_10.png" alt="" class="img-responsive"/>
	                            <p class="newsPerP"><span class="newsPer">10</span>%</p>
	                        </div>
	                    </li>
					</#list>
                
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="js/mui.min.js"></script>
<script src="js/jquery-1.11.3.js"></script>

<script>
window.onload = function(){
    //要执行的js代码段
    var w=$('.maskPic').css('width'),
        h=$('.maskPic').css('height');
    $('.maskImg').css('height',h);
    $('.maskImg').css('width',w);
    $('.maskTxt').css('width',w);
};

//    退出
    $('.quitIndex').click(function(){
        $('.mask').fadeIn();
    });
    $('.indexActKnow').click(function(){
        $('.mask').fadeOut();
    });
    $('.indexActQuit').click(function(){
        window.location.href="${system.basePath}/loginOut";
    });

// 跳转
    $('#gift').on('tap',function(){
        window.location.href="${system.basePath}/app/queryDonorHis";
//        window.location.href="mine_giftNull.html";
    });
    $('#contribute').on('tap',function(){
        window.location.href="${system.basePath}/app/queryDonatedContract";
//        window.location.href="mine_contributeNull.html";  //queryDonatedContract
    });
    $('.newsAll').on('tap','li',function(){
          var smartContractAddr = this.getAttribute("id");
          window.location.href="${system.basePath}/app/querySmartContract?smartContractAddr="+smartContractAddr;
        //window.location.href="mine_contribute.html";
        
    });

//str2.replace(/,/g,"")
function shui(){
    var li=$('.newsAll li');
    for(var i=0;i<li.length;i++){
        var yi=parseFloat(($(li[i]).find('.newsMoney p:first-child span')).html().replace(/,/g,"")),
                all=parseFloat(($(li[i]).find('.newsMoney p:last-child span')).html().replace(/,/g,""));
        var per=(yi/all*100).toFixed(2);
        ($(li[i]).find('.newsPer')).text(per);
        var perNum= ($(li[i]).find('.newsPer')).text();
        
        if( perNum==0 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_0.png');
        }else if( 0<perNum && perNum<=5 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_5.png');
        }else if( 5<perNum && perNum<=10 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_10.png');
        }else if( 10<perNum && perNum<=20 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_20.png');
        }else if( 20<perNum && perNum<=30 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_30.png');
        }else if( 30<perNum && perNum<=40 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_40.png');
        }else if( 40<perNum && perNum<=50 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_50.png');
        }else if( 50<perNum && perNum<=60 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_60.png');
        }else if( 60<perNum && perNum<=70 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_70.png');
        }else if( 70<perNum && perNum<=80 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_80.png');
        }else if( 80<perNum && perNum<=90 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_90.png');
        }else if( 90<perNum && perNum<100 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_95.png');
        }else if( perNum==100 ){
            $(li[i]).find('.newsImg img').attr('src','img/index/per_100.png');
        }

    }
}
shui();


//刷新加载
mui.init({
    pullRefresh : {
        container:'#offCanvasContentScroll',//待刷新区域标识，querySelector能定位的css选择器均可，比如：id、.class等
        up : {
            height:50,//可选.默认50.触发上拉加载拖动距离
            contentrefresh : "加载中...",//可选，正在加载状态时，上拉加载控件上显示的标题内容
            contentnomore:'没有更多数据了',//可选，请求完毕若没有更多数据时显示的提醒内容；
            callback :more //必选，刷新函数，根据具体业务来编写，比如通过ajax从服务器获取新数据；
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
    ul =$("#offCanvasContentScroll .newsAll");
    for (i=0; i<3; i++) {
        //str=$('<li class="mui-table-view-cell mui-row"><div class="mui-col-xs-4 newsMask"><img src="img/index/news02.png" alt="" class="img-responsive maskPic"/><p class="maskImg"></p><p class="maskTxt">共<span>1234</span>份爱心</p></div><div class="mui-col-xs-7 newsDel"><p class="newsTitle">宁夏母亲水窖项目</p><p class="newsTxt">项目简介项目简介项目简介项目简介罕见的反馈个梵蒂冈</p><div class="newsMoney"><p>已筹<span>100</span>万元</p><p>目标<span>2000</span>万元</p></div></div><div class="mui-col-xs-1 newsImg"><img src="img/index/per_10.png" alt="" class="img-responsive"/><p class="newsPerP"><span class="newsPer"></span>%</p></div></li>');
        ul.append(str);
    }
//  this.endPullupToRefresh(true);
//    mui('#offCanvasContentScroll').pullRefresh().endPulldownToRefresh();
    this.endPullupToRefresh(false);

    var w=$('.maskPic').css('width'),
            h=$('.maskPic').css('height');
    $('.maskImg').css('height',h);
    $('.maskImg').css('width',w);
    $('.maskTxt').css('width',w);
    shui();

}


   


</script>
</body>

</html>