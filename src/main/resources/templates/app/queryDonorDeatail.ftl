<!DOCTYPE HTML>
<html >
<head>
    <meta charset="utf-8">
    <title>捐款详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_gift.css" rel="stylesheet">
</head>
<body>

<!--凭证-->
<div class="mask">
    <div class="maskBack">
        <div class="maskIcon">
            <img src="${system.basePath}/img/common/pzBackIcon.png" alt=""/>
            <!--title-->
            <div class="maskTxt">
                <div class="txtTitle">
                    <p class="title">微公益捐款凭证</p>
                    <p class="pzH">公益链凭证号(哈希):<span>${processDonored.donorUUID?if_exists[0..20]}</span></p>
                </div>
            </div>
            <!--ul-->
            <ul class="maskDel">
                <li class=" over">
                    <span class="lf">捐款人</span>
                    <span class="rt">${name?if_exists}</span>
                </li>
                <li class=" over">
                    <span class="lf">收款方</span>
                    <span class="rt">${processDonored.smartContractName?if_exists}</span>
                </li>
                <li class=" over">
                    <span class="lf">捐款时间</span>
                    <span class="rt">${processDonored.donorTimeStr?if_exists}</span>
                </li>
            </ul>
            <!--ul-->
            <ul class="maskDel maskMoney">
                <li class="over">
                    <span class="lf">捐款金额</span>
                    <span class="rt"><span>${processDonored.amountStr?if_exists}</span>元</span>
                </li>
                <li class="over">
                    <span class="lf">基金管理费(0.${donorContribution.smartContract.channelFee?if_exists}%)</span>
                    <span class="rt"><span>${processDonored.fundAmountStr?if_exists}</span>元</span>
                </li>
                <li class="over">
                    <span class="lf">渠道费(0.${donorContribution.smartContract.fundManangerFee?if_exists}%)</span>
                    <span class="rt"><span>${processDonored.channelAmountStr?if_exists}</span>元</span>
                </li>
            </ul>
            <!--ul-->
            <ul class="maskDel maskRoad">
                <li class="over">
                    <span class="lf">受理渠道</span>
                    <span class="rt">瑶瑶缴费</span>
                </li>
            </ul>
            <!--txt-->
            <div class="maskText">
                感谢您参与 <u>${processDonored.smartContractName?if_exists}</u>的捐款活动，此次捐款是由区块链技术支持，其捐款凭证号（哈希）是捐款唯一凭证，不可篡改。
            </div>
        </div>
    </div>
    <p class="closeCon"><img src="${system.basePath}/img/common/close.png" alt="" id="closeMask"/></p>
</div>

<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">捐款详情</p>
        	<button id="lookPz" class="rt lookPz">查看凭证</button>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section ">
            <!--news-->
            <div class="newsCon">
                <div class="details">
                    <p class="deTitle">${donorContribution.smartContractName?if_exists}</p>
                    <p class="deMoney"><span>${donorContribution.amountStr?if_exists}</span> 元</p>
                    <p class="deStatus">捐献成功</p>
                </div>
            </div>
            <!--ul 凭证号-->
            <ul class="giftDel mui-table-view">
                <li class="mui-table-view-cell over" id="PZHao">
                    <span class="lf">公益链凭证号</span>
                    <span class="rt hao">${processDonored.donorUUID?if_exists}</span>
                </li>
            </ul>
            <!--ul-->
            <ul class="giftDel mui-table-view">
                <li class="mui-table-view-cell over">
                    <span class="lf">收款方</span>
                    <span class="rt">${donorContribution.smartContractName?if_exists}</span>
                </li>
                <li class="mui-table-view-cell over">
                    <span class="lf">捐款人</span>
                    <span class="rt">${name?if_exists}</span>
                </li>
            </ul>
            <!--ul-->
            <ul class="giftDel mui-table-view">
                <li class="mui-table-view-cell over">
                    <span class="lf">捐款时间</span>
                    <span class="rt">${processDonored.donorTimeStr}</span>
                </li>
                <li class="mui-table-view-cell over">
                    <span class="lf">捐款渠道</span>
                    <span class="rt">瑶瑶缴费</span>
                </li>
            </ul>
            <!--ul-->
            <ul class="giftDel mui-table-view">
                <li class="mui-table-view-cell over">
                    <span class="lf">合约账户实收</span>
                    <span class="rt"><span>${processDonored.smartContractAmountStr?if_exists}</span>元</span>
                </li>
                <li class="mui-table-view-cell over">
                    <span class="lf">基金管理费(0.${donorContribution.smartContract.fundManangerFee?if_exists}%)</span>
                    <span class="rt"><span>${processDonored.fundAmountStr?if_exists}</span>元</span>
                </li>
                <li class="mui-table-view-cell over">
                    <span class="lf">渠道费(0.${donorContribution.smartContract.channelFee?if_exists}%)</span>
                    <span class="rt"><span>${processDonored.channelAmountStr?if_exists}</span>元</span>
                </li>
            </ul>
            <!--ul-资金流向-->
            <ul class="giftDel mui-table-view">
                <li class="mui-table-view-cell over">
                    <span class="lf">资金流向</span>
                    <!--<span class="rt hao"></span>-->
                </li>
                <#if (donorTrackDetail.drawList?if_exists?size > 0)>
                	 <li class="moneyIcon lxIcon-${donorTrackDetail.drawList?if_exists?size}">
                    <p class="lxIcon"><img src="${system.basePath}/img/common/lxIcon-${donorTrackDetail.drawList?if_exists?size}.png" alt=""/></p>
                    <div class="lxTxt jk"><p>发起捐款</p><p>${donorTrackDetail.donorAmountStr?if_exists}¥</p></div>
                    <div class="lxTxt qd"><p>渠道账户</p><p>${donorTrackDetail.channelAmountStr?if_exists} ¥</p></div>
                    <div class="lxTxt jjgl"><p>基金管理账户</p><p>${donorTrackDetail.fundAmountStr?if_exists} ¥</p></div>
                    <div class="lxTxt qkl"><p>合约<br/>区块链账户</p><p>${donorTrackDetail.contractAmountStr?if_exists} ¥</p></div>
                    <#if (donorTrackDetail.drawList?if_exists?size > 0)>
	                    <#list donorTrackDetail.drawList as drawObj>
	                    	<div class="lxTxt xm xm0${drawObj_index+1}" id="${drawObj.accountAddr?if_exists}"><p>${drawObj.accountName?if_exists}</p><p>${drawObj.amountStr?if_exists} ¥</p><p></p></div>
	                    </#list>
                    </#if>
                    <div class="lj lj01" id="${donorTrackDetail.donorid?if_exists}" type="donor">1</div>
                    <#if (donorTrackDetail.drawList?if_exists?size > 0)>
	                    <#list donorTrackDetail.drawList as drawObj>
	                    	<div class="lj lj0${drawObj_index+2}" id="${drawObj.drawid?if_exists}" type="draw">${drawObj_index+2}</div>
	                    </#list>
                    </#if>
                </li>
                
                <#else>
                 		 <!--0-->
		                <li class="moneyIcon lxIcon-0">
		                    <p class="lxIcon"><img src="${system.basePath}/img/common/lxIcon-0.png" alt=""/></p>
		                    <div class="lxTxt jk"><p>发起捐款</p><p>${donorTrackDetail.donorAmountStr?if_exists}¥</p></div>
		                    <div class="lxTxt qd"><p>渠道账户</p><p>${donorTrackDetail.channelAmountStr?if_exists} ¥</p></div>
		                    <div class="lxTxt jjgl"><p>基金管理账户</p><p>${donorTrackDetail.fundAmountStr?if_exists} ¥</p></div>
		                    <div class="lxTxt qkl"><p>合约<br/>区块链账户</p><p>${donorTrackDetail.contractAmountStr?if_exists} ¥</p></div>
		                    <div class="lj lj01" id="${donorTrackDetail.donorid?if_exists}" type="donor">1</div>
		                </li>
                </#if>
                
                
                
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
$('#PZHao').on('tap',function(){
    // window.location.href="mine_giftDel_pzDel.html";
     $('.mask').css('display','block');
});
//交易凭证
//$('.giftDelHao').on('tap','.dealHao',function(){
//    window.location.href="mine_giftDel_dealDel.html";
//});
$('.xm').on('tap',function(){
	var bargainId = this.getAttribute("id");
	//alert("bargainId="+bargainId)
    window.location.href="${system.basePath}/app/queryBargain?bargainId="+bargainId;
});
$('.lj').on('tap',function(){
	var donorid = this.getAttribute("id");
	var type = this.getAttribute("type");
	window.location.href="${system.basePath}/app/queryDonorTransDeatail?donorid="+donorid+"&type="+type;
});


window.onload=function(){
    var h=( parseFloat($('.pubStates').css('width'))-29-19-35)/($('.pubStates:first p').length-1);
    $('.pubYes').css('width',h+'px');
};




    mui('#offCanvasContentScroll').scroll();

    var btn = document.getElementById("lookPz"),
        closeBtn = document.getElementById("closeMask");
    btn.addEventListener('tap',function(){
        $('.mask').css('display','block');
    });
    closeBtn.addEventListener('tap',function(){
        $('.mask').css('display','none');
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
    max('.giftDel li span.rt.hao',14);



</script>
</body>

</html>