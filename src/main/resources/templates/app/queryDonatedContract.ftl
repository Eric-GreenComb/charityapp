<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的捐赠项目</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_contribute.css" rel="stylesheet">
</head>
<body>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">我的捐赠项目</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <ul class="newsAll mui-table-view">
            	<#list contributionsList as contribution>
	                <li class="mui-table-view-cell mui-row" id="${contribution.smartContractAddr}" donateYuan="${contribution.smartContractExt.validTotalYuan?if_exists}">
	                    <div class="mui-col-xs-4 newsMask">
	                        <img src="${system.basePath}/img/index/news01.png" alt="" class="img-responsive maskPic"/>
	                        <p class="maskImg"></p>
	                        <p class="maskTxt">共<span>${contribution.smartContractExt.donateNumber?if_exists}</span>份爱心</p>
	                    </div>
	                    <div class="mui-col-xs-8 newsDel">
	                        <p class="newsTitle">${contribution.smartContractName}</p>
	                        <p class="newsTxt">已筹集善款<span> ${contribution.smartContractExt.validTotalYuan?if_exists} </span>元</p>
	                        <div class="newsMoney">
	                            <p>我的捐款<span> ${contribution.amountStr} </span>元</p>
	                            <p>我已捐款<span> ${contribution.donorNumber} </span>次</p>
	                        </div>
	                    </div>
	                    <div class="traceIng traceStatus">筹集中</div>
	                </li>
                </#list>
               
            </ul>
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

    $('.newsAll').on('tap','li',function(){
    	  var smartContractAddr = this.getAttribute("id");
    	  var donateYuan = this.getAttribute("donateYuan");
        window.location.href="${system.basePath}/app/queryContributeGo?smartContractAddr="+smartContractAddr+"&donateYuan="+donateYuan;
    
          //window.location.href="mine_contributeGo.html";
		  //window.location.href="mine_contributeGoNull.html";
    });



    window.onload = function(){
        //要执行的js代码段
        var w=$('.maskPic').css('width'),
            h=$('.maskPic').css('height');
        $('.maskImg').css('height',h);
        $('.maskImg').css('width',w);
        $('.maskTxt').css('width',w);
    };

    //限制方法
    function max(yuan,len){
        var y=$(yuan);
        for( var i= 0,maxwidth=len;i< y.length;i++ ){
            if(y[i].innerHTML.length>maxwidth){
                y[i].innerHTML=y[i].innerHTML.substring(0,maxwidth)+'...';
            }
        }
    }
    //book_detail
    max('.giftTitle',10);

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
            str=$('<li class="mui-table-view-cell mui-row"><div class="mui-col-xs-4 newsMask"><img src="img/index/news01.png" alt="" class="img-responsive maskPic"/><p class="maskImg"></p><p class="maskTxt">共<span>1234</span>份爱心</p></div><div class="mui-col-xs-8 newsDel"><p class="newsTitle">宁夏母亲水窖项目</p><p class="newsTxt">已筹集善款<span> 100000.00 </span>元</p><div class="newsMoney"><p>我的捐款<span> 1000.00 </span>元</p><p>我已捐款<span> 22 </span>次</p></div></div><div class="traceIng traceStatus">筹集中</div></li>');
            ul.append(str);
        }
//      this.endPullupToRefresh(true);
        this.endPullupToRefresh(false);
        //width
        var w=$('.maskPic').css('width'),
                h=$('.maskPic').css('height');
        $('.maskImg').css('height',h);
        $('.maskImg').css('width',w);
        $('.maskTxt').css('width',w);

    }



</script>
</body>

</html>