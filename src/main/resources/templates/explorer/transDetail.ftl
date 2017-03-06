<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="UTF-8">
    <title>交易详情</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_pc.css"/>
</head>
<body>

<!--mask-->
<div class="dealDel">
<div class="maskAll">
    <div class="dealMask">
        <p class="dealTitle">合约详情</p>
        <p class="maskColor"></p>
        <#if smartContract??>
        <ul class="maskUl">
            <li><p>捐款合约ID：<span>${donorTransRel.contractIdStr?if_exists}</span></p></li>
            <li><p>捐款合约名称：<span>${smartContract.name?if_exists}</span></p></li>
            <li><p>基金会：<span>${smartContract.fundName?if_exists}</span></p></li>
        </ul>
        <ul class="maskUl">
            <li><p>捐款金额限制：<span><#if smartContract.type??>无限制<#elseif  smartContract.type?if_exists ='0'>金额限制 <#else>时间限制</#if></span></p></li>
            <li><p>渠道服务费：<span>${smartContract.channelFeeStr?if_exists}%</span></p></li>
            <li><p>基金管理费：<span>${smartContract.fundManangerFeeStr?if_exists}%</span></p></li>
        </ul>
        <ul class="maskUl">
            <li><p>合约生效时间：<span>
            <#if smartContract.utilTimeStr?? > 
            	${smartContract.createTimeStr?if_exists?substring(0,10)}
			<#elseif smartContract.utilTimeStr?? && smartContract.utilTimeStr?length gt 10>
				${smartContract.utilTimeStr?if_exists?substring(0,10)}
			<#else>
				${smartContract.createTimeStr?if_exists?substring(0,10)}
            </#if>
            </span></p></li>
            <li><p>合约失效时间：<span><#if smartContract.endTimeStr?? && smartContract.endTimeStr?length gt 10>  ${smartContract.endTimeStr?if_exists?substring(0,10)}  </#if></span></p></li>
        </ul>
        </#if>
    </div>
    <p class="close"><img src="${system.basePath}/img/common_pc/closeIcon.png" alt=""/></p>
    </div>
</div>


<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv" id="backExplorerIndex">
            <img src="${system.basePath}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
           <p class="search_con">
                <input type="text" id="searchVal" class="search" value="" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="javascript:searchDetail();"><img src="${system.basePath}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        
        <div class="partYi">
            <p class="partName">交易信息</p>
             <#if transaction.txid ?if_exists !=''>
            	<p class="partInfo"><span>交易ID</span><span class="color">${transaction.txid?if_exists}</span></p>
             </#if>
             <#if transaction.transMoney ?if_exists !='--'>
            <p class="partInfo"><span>交易金额</span><span><span>&yen;${transaction.transMoney?if_exists}  </span><span class="dealConfirm">交易已确认</span></span></p>
             </#if>
            <p class="partInfo"><span>所在区块(stateHash)</span><a href="${system.basePath}/explorer/blockDetail?heigh=${donorTransRel.blockHeight?if_exists}" class="color partDelNum">${donorTransRel.blockHash?if_exists}</a></p>
            <p class="partInfo"><span>接收时间</span><span>${transaction.tranGenTime?if_exists}</span></p>
             <#if donorTransRel.contractIdStr??>
            <p class="partInfo"><span>合约ID</span><span class="color" id="contractId">${donorTransRel.contractIdStr?if_exists}</span></p>
            </#if>
        </div>
        <!--tu-->
        <div class="moneyAll">
        	<#if donorTransRel.contractIdStr??>
	        	<#if donorTransRel.type?if_exists='1'>
			        	 <span class="jkr">捐款人账户</span>
			            <span>&yen;${donorTrackDetail.donorAmountStr?if_exists}</span>
			            <img src="${system.basePath}/img/common_pc/zhuan.png" alt="" class="zhuan"/>
			            <ul class="dealMoney">
			                <li><span class="lf">合约账户</span><span class="rt">&yen;${donorTrackDetail.contractAmountStr?if_exists}</span></li>
			                <li><span class="lf">慈善基金账户</span><span class="rt">&yen;${donorTrackDetail.fundAmountStr?if_exists}</span></li>
			                <li><span class="lf">捐款渠道账户</span><span class="rt">&yen;${donorTrackDetail.channelAmountStr?if_exists}</span></li>
			            </ul>
	        	<#elseif donorTransRel.type?if_exists='2'>
	        	
			        	 <span class="jkr">合约账户</span>
			            <span>${transaction.transMoney?if_exists}</span>
			            <img src="${system.basePath}/img/common_pc/zhuan.png" alt="" class="zhuan"/>
			            <ul class="dealMoney">
			                <li><span class="jkr"></span><span class="rt"></span></li>
			                <li><span class="jkr">施工方账户</span><span class="rt">${transaction.transMoney?if_exists?replace('-','')} &yen;</span></li>
			                <li><span class="jkr"></span><span class="rt"></span></li>
			            </ul>
	        	<#else>
	        	</#if>
        	</#if>
           
        </div>
        <!--序列化信息-->
        <div class="partXlh">
            <p class="partName"><span class="lf">写入信息(区块中记录的序列化信息)</span><button class="rt transfer" id="transfer">进行转义</button></p>
            <p class="partShu" id="payloadStr">${transaction.payload?if_exists}</p>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common_pc.js"></script>
<script src="${system.basePath}/js/base64Util.js"></script>
<script>
	var bObj = document.getElementById("backExplorerIndex"); 
		bObj.addEventListener("click",backIndex,false); 
		function backIndex(){
			window.location.href="${system.basePath}/explorer/index";
		} 

function goBlockDetail(height){
	window.location.href="${system.basePath}/explorer/blockDetail?heigh="+height;
}

 $('#transfer').click(function(){
        if($(this).html()=="进行转义"){
        	var payloadStr =$("#payloadStr").html();
        	$("#payloadStr").html(base64decode(payloadStr))
            $(this).html("取消转义")
        }else{
        	//base64encode
        	var payloadStr =$("#payloadStr").html();
        	$("#payloadStr").html(base64encode(payloadStr))
            $(this).html("进行转义")
        }
    });
    
    function searchDetail(){
		var searchVal=$("#searchVal").val();
		console.log("searchVal="+searchVal)
		if(""!=searchVal){
			window.location.href="${system.basePath}/explorer/searchDetail?searchVal="+searchVal;
		}else{
			alert("请输入查询条件,区块高度或是txid!")
		}
		
	}
</script>
</body>
</html>