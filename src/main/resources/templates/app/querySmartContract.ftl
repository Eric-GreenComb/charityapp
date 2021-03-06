<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>项目详情--筹集中</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_contributeGoDel.css" rel="stylesheet">
</head>
<body>

<!--捐款-->
<div class="mask conMask" id="mask">
    <div class="maskBack">
        <div class="maskWhite" id="maskWhite"></div>
        <div class="maskBackCon">
            <div class='contributeMoney' id="closeContributeMoney">
                <div class="mui-row contributeMoneyDiv">
                    <p class="mui-col-xs-3 contributeMoneyTxt">捐款金额</p>
                    <p class="mui-col-xs-9 contributeMoneyMuch contributeMoneyTxt"><input type="number" id="donorAmount" placeholder="输入1元以上的捐款金额"/>元</p>
                </div>
                <div class="mui-row contributeMoneyDiv">
                    <p class="mui-col-xs-3"></p>
                    <p class="mui-col-xs-9 conDu">可捐款额度为<span id="conDonateMoney"> ${SmartContractExt.canDonateNumberStr?if_exists} </span>元</p>
                </div>
            </div>
            <div class="foot" id="closeFoot">
                <button id="enter">确认捐款</button>
            </div>
        </div>
    </div>
</div>
<!--确认捐款mask-->
<div class="mask enterMask" id="enterMask">
    <span><img src="${system.basePath}/img/common/timg.gif" alt=""/><br/>加载中...</span>
</div>


<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">项目详情</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section">
            <!--top-->
            <div class="goTop">
                <img src="${system.basePath}/img/mine/goDel01.png" alt=""/>
                <p class="goTopMask over">${SmartContractExt.smartContract.name?if_exists}</p>
                <p class="raise"><img src="${system.basePath}/img/mine/raiseIng.png" alt=""/></p>
            </div>
            <!--money-->
            <div class="mui-row delMoney">
                <dl class="mui-col-xs-4">
                    <dt><img src="${system.basePath}/img/index/per_0.png" alt="" class="perHow"/></dt>
                    <dd class="newsPer">10%【fake】</dd>
                </dl>
                <dl class="mui-col-xs-4">
                    <dt>已筹金额</dt>
                    <dd><span class="alreadyMoney">${SmartContractExt.totalStr?if_exists}</span>万元</dd>
                </dl>
                <dl class="mui-col-xs-4">
                    <dt>目标金额</dt>
                    <dd><span class="allMoney">${SmartContractExt.smartContract.goalStr?if_exists}</span>万元</dd>
                </dl>
            </div>
            <!--简介-->
            <div class="mui-content briefAll">
                <div id="slider" class="mui-slider">
                    <!--title-->
                    <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
                        <a class="mui-control-item mui-active" href="#item1mobile">项目简介</a>
                        <a class="mui-control-item" href="#item3mobile">基本信息</a>
                    </div>
                    <!--线-->
                    <div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>
                    <!--del-->
                    <div class="mui-slider-group">
                        <div id="item1mobile" class="mui-slider-item mui-control-content mui-active">
                            <div id="scroll1" class="mui-scroll-wrapper tab">
                                <div class="mui-scroll">
                                    <div class='bookDel'>
                                        <img src="${system.basePath}/${smartContract.detail?if_exists}" alt="" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="item3mobile" class="mui-slider-item mui-control-content">
                            <div id="scroll3" class="mui-content mui-scroll-wrapper tab">
                                <div class="mui-scroll">
                                    <ul class="traceUl ">
                                        <li class="over">
                                            <span class="lf">基金会：</span>
                                            <span class="rt">${SmartContractExt.smartContract.partyA?if_exists}</span>
                                        </li>
                                        <li class="over">
                                            <span class="lf">基金管理费：</span>
                                            <span class="rt">${SmartContractExt.smartContract.fundManangerFeeStr?if_exists}%</span>
                                        </li>
                                        <li class="over">
                                            <span class="lf">捐献渠道：</span>
                                            <span class="rt">瑶瑶缴费</span>
                                        </li>
                                        <li class="over">
                                            <span class="lf">渠道服务费：</span>
                                            <span class="rt">${SmartContractExt.smartContract.channelFeeStr?if_exists}%</span>
                                        </li>
                                        <li class="over">
                                            <span class="lf">生效时间：</span>
                                            <span class="rt">${SmartContractExt.smartContract.createTimeStr?if_exists}</span>
                                        </li>
                                        <li class="over">
                                            <span class="lf">结束时间：</span>
                                            <span class="rt">${SmartContractExt.smartContract.endTimeStr?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--合约-->
            <ul class="mui-table-view contract">
                <li class="mui-table-view-cell">
                     <a class="mui-navigate-right contractTxt" id="contractTxt">查看项目合约</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--foot-->
<div class="foot">
    <button id="lookPz">我要捐款</button>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/mui.min.js"></script>
<script>

    //    跳转
    $('.user').on('tap',function(){
        window.history.back(-1);
    });

	$('#contractTxt').on('tap',function(){
        window.location.href="${system.basePath}/app/querySmartContractDetail";
    });
	$('#enter').on('tap',function(){
		//$('#enterMask').fadeIn();
	       var donorAmount=$("#donorAmount").val();
	       var smartContractAddr='${SmartContractExt.smartContract.addr?if_exists}';
	       if(isRightMoney(donorAmount)){
	     		 window.location.href="${system.basePath}/app/ccpay?donorAmount="+donorAmount+"&smartContractAddr="+smartContractAddr+"&tm="+new Date().getTime() ;
	       }else{
	      	 	mui.alert("请重新填写正确的金额")  
	       		$("#donorAmount").val(100);  	
	       }
	   });
 
    function blurNum(donateNum){
    	if(isPositiveNum(donateNum)){
			alert("不是数字")    	
    	}else{
    		donateNum.value=1; 
    	}
    }

		function isPositiveNum(s){//是否为正整数  
		    var re = /^[0-9]*[1-9][0-9]*$/ ;  
		    return re.test(s)  
		} 


		function isRightMoney(money){
		
			var reg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
		     //var money = "520.100";
		     //000 错
		     //0 对
		     //0. 错
		     //0.0 对
		     //050 错
		     //00050.12错
		     //70.1 对
		     //70.11 对
		     //70.111错
		     //500 正确
		     
		     var conDonateMoney=$("#conDonateMoney").html();
		     conDonateMoney=parseFloat(conDonateMoney.replace(/,/g,""));
		     if (reg.test(money)) {
		     	  if(parseFloat(money)==0){
		     	  	return false;
		     	  }
		     	  if(parseFloat(money)>parseFloat(conDonateMoney)){
		     	  		mui.alert("您的捐款已经超过可捐款额度了，您可以选择其他合约进行捐款!")  
		     	  	return false;
		     	  }
		     
		     	  if(money.length>10){
		     	  		mui.alert("少年，你确定你要捐赠这么多钱吗?")  
		     	  	return false;
		     	  }
		          return true;
		     }else{
		          return false;
		     };
		}


    (function($) {
        $('.mui-scroll-wrapper').scroll({
            //是否显示滚动条
            indicators: false
        })
    })(mui);

//关闭高度
window.onload=function(){
    var h=(window.screen.availHeight)-156;
    //console.log(h);
    $('.maskWhite').css('height',h+'px');
}

//    水滴
var yi=parseFloat($('.alreadyMoney').html().replace(/,/g,"")),
    all=parseFloat($('.allMoney').html().replace(/,/g,""));
console.log("yi="+yi+" all="+all );
if(isNaN(yi)){ 
yi=0;
}

console.log("yi="+yi+" all="+all );
$('.newsPer').html((yi/all*100).toFixed(2)+'%');


function shui(){
    var per=yi/all*100;
    if( per==0 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_0.png');
    }else if( 0<per && per<=5 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_5.png');
    }else if( 5<per && per<=10 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_10.png');
    }else if( 10<per && per<=20 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_20.png');
    }else if( 20<per && per<=30 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_30.png');
    }else if( 30<per && per<=40 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_40.png');
    }else if( 40<per && per<=50 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_50.png');
    }else if( 50<per && per<=60 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_60.png');
    }else if( 60<per && per<=70 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_70.png');
    }else if( 70<per && per<=80 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_80.png');
    }else if( 80<per && per<=90 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_90.png');
    }else if( 90<per && per<100 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_95.png');
    }else if( per==100 ){
        $('.perHow').attr('src','${system.basePath}/img/index/per_100.png');
    }

}
shui();


    //捐款打开
    var btn = document.getElementById("lookPz");
    btn.addEventListener('tap',function(){
//        $('#mask'). slideDown();

		 var conDonateMoney=$("#conDonateMoney").html();
		 conDonateMoney=parseFloat(conDonateMoney.replace(/,/g,""));
     	  if(parseFloat(conDonateMoney)==0){
     	  		mui.alert("该项目已经筹集到全部捐款了，您可以去捐其他的项目!")  
     	  		return ;
     	  	}
		
        $('#mask').css({"top":0,"transition":'350ms'});
    });
    //空白关闭
    var div=document.getElementById('maskWhite');
    div.addEventListener('tap',function(e) {
        //console.log('hidden', e.detail.id);//detail为当前popover元素
        $('.mask').fadeOut();
    });

    //    简介
//    (function($) {
//        mui('.mui-scroll-wrapper').scroll({
//            indicators: false //是否显示滚动条
//        });
//    })(mui);

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