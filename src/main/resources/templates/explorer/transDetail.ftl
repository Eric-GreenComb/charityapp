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
    <div class="dealMask">
        <p class="dealTitle">合约详情</p>
        <p class="maskColor"></p>
        <ul class="maskUl">
            <li><p>捐款合约ID：<span>${donorTransRel.contractIdStr?if_exists}</span></p></li>
            <li><p>捐款合约名称：<span>${smartContract.name?if_exists}</span></p></li>
            <li><p>基金会：<span>${smartContract.fundName?if_exists}</span></p></li>
        </ul>
        <ul class="maskUl">
            <li><p>捐款金额限制：<span><#if smartContract.type??>无限制<#elseif  smartContract.type?if_exists ='0'>金额限制 <#else>时间限制</#if></span></p></li>
            <li><p>渠道服务费：<span>0.${smartContract.channelFee?if_exists}%</span></p></li>
            <li><p>基金管理费：<span>0.${smartContract.fundManangerFee?if_exists}%</span></p></li>
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
    </div>
    <p class="close"><img src="${system.basePath}/img/common_pc/closeIcon.png" alt=""/></p>
</div>


<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv">
            <img src="${system.basePath}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
            <p class="search_con">
                <input type="text" id="search" class="search" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="#"><img src="${system.basePath}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <div class="partYi">
            <p class="partName">交易信息</p>
            <p class="partInfo"><span>交易ID</span><span class="color">${transaction.txid?if_exists}</span></p>
            <p class="partInfo"><span>交易金额</span><span>${transaction.transMoney?if_exists} &yen;</span><span>交易已确认</span></p>
            <p class="partInfo"><span>所在区块(stateHash)</span><a href="javascript:goBlockDetail('${donorTransRel.blockHeight?if_exists}');" class="color">${donorTransRel.blockHash?if_exists}</a></p>
            <p class="partInfo"><span>接收时间</span><span>${transaction.tranGenTime?if_exists}</span></p>
            <p class="partInfo"><span>合约ID</span><span class="color" id="contractId">${donorTransRel.contractIdStr?if_exists}</span></p>
        </div>
        <!--tu-->
        <div class="moneyAll">
        	<#if donorTransRel.type?if_exists='1'>
		        	 <span class="jkr">捐款人标识</span>
		            <span>${donorTrackDetail.donorAmountStr?if_exists}&yen;</span>
		            <img src="${system.basePath}/img/common_pc/zhuan.png" alt="" class="zhuan"/>
		            <ul class="dealMoney">
		                <li><span class="lf">合约账户</span><span class="rt">${donorTrackDetail.contractAmountStr?if_exists}&yen;</span></li>
		                <li><span class="lf">基金管理费账户</span><span class="rt">${donorTrackDetail.fundAmountStr?if_exists}&yen;</span></li>
		                <li><span class="lf">渠道账户</span><span class="rt">${donorTrackDetail.channelAmountStr?if_exists}&yen;</span></li>
		            </ul>
        	<#else >
        	
		        	 <span class="jkr">合约账户</span>
		            <span>${transaction.transMoney?if_exists}</span>
		            <img src="${system.basePath}/img/common_pc/zhuan.png" alt="" class="zhuan"/>
		            <ul class="dealMoney">
		                <li><span class="jkr"></span><span class="rt"></span></li>
		                <li><span class="jkr">合同账户</span><span class="rt">${transaction.transMoney?if_exists?replace('-','')} &yen;</span></li>
		                <li><span class="jkr"></span><span class="rt"></span></li>
		            </ul>
        	
        	</#if>
        
           
        </div>
        <!--序列化信息-->
        <div class="partXlh">
            <p class="partName">写入信息(区块中记录的序列化信息)</p>
            <p class="partShu">${transaction.payload?if_exists}</p>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common_pc.js"></script>
<script>
function goBlockDetail(height){
	window.location.href="${system.basePath}/explorer/blockDetail?heigh="+height;
}
</script>
</body>
</html>