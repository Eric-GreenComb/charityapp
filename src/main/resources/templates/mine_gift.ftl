<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>捐款记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css/mui.min.css">
    <link href="css/common.css" rel="stylesheet">
    <link href="css/mine_gift.css" rel="stylesheet">
</head>
<body>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="img/common/back.png" alt=""/></p>
        <p class="headerTitle">捐款记录</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <!--news-->
            <div class="newsCon">
                <ul class="newsAll mui-table-view">
                	<#list donorHisList as donorHis>
                		<li class="mui-table-view-cell mui-row">
	                        <div class="mui-col-xs-2 giftLeft">
	                            <p class="day">${donorHis.donorTimeStr?if_exists?substring(0,10)}</p>
	                            <p class="time">${donorHis.donorTimeStr?if_exists?substring(10,20)}</p>
	                        </div>
	                       <div class="mui-col-xs-10 over giftRight">
	                           <span class="giftTitle lf">${donorHis.smartContractName?if_exists}</span>
	                           <span class="giftMoney rt"><span>&yen;${donorHis.amount?if_exists}</span><img src="img/common/more.png" alt=""/></span>
	                       </div>
                   		</li>
                    </#list>
                    <li class="mui-table-view-cell mui-row">
                        <div class="mui-col-xs-2 giftLeft">
                            <p class="day">今天</p>
                            <p class="time">12:00</p>
                        </div>
                       <div class="mui-col-xs-10 over giftRight">
                           <span class="giftTitle lf">宁夏母亲水窖项目各环节的老公哈萨克的刚开始都很快乐撒大哥</span>
                           <span class="giftMoney rt"><span>&yen;50.00</span><img src="img/common/more.png" alt=""/></span>
                       </div>
                    </li>
                    <li class="mui-table-view-cell mui-row giftFail">
                        <div class="mui-col-xs-2 giftLeft">
                            <p class="day">12/01</p>
                            <p class="time">12:00</p>
                        </div>
                        <div class="mui-col-xs-10 over giftRight">
                            <span class="giftTitle lf">宁夏母亲水窖项目</span>
                            <span class="giftMoney rt"><span>&yen;50.00</span><img src="img/common/giftFali.png" alt=""/></span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="js/mui.min.js"></script>
<script src="js/jquery-1.11.3.js"></script>

<script>
function goback(){
    alert(1)
}
    //页面跳转
    $('.user').on('tap',function(){
        window.history.back(-1);
    });
    $('.newsAll').on('tap','li',function(){
        window.location.href="mine_giftDel.html";
    });


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
            str=$('<li class="mui-table-view-cell mui-row"><div class="mui-col-xs-4 newsMask"><img src="img/index/news02.png" alt="" class="img-responsive maskPic"/><p class="maskImg"></p><p class="maskTxt">共<span>1234</span>份爱心</p></div><div class="mui-col-xs-7 newsDel"><p class="newsTitle">宁夏母亲水窖项目</p><p class="newsTxt">项目简介项目简介项目简介项目简介罕见的反馈个梵蒂冈</p><div class="newsMoney"><p>已筹<span>1000</span>万元</p><p>目标<span>2000</span>万元</p></div></div><div class="mui-col-xs-1"><img src="img/index/per_10.png" alt="" class="img-responsive"/><span class="newsPer">10%</span></div></li>');
            ul.append(str);
        }
//      this.endPullupToRefresh(true);
        this.endPullupToRefresh(false);
    }



</script>
</body>

</html>