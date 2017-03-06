<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>交易详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="${system.basePath}/css/mui.min.css">
    <link href="${system.basePath}/css/common.css" rel="stylesheet">
    <link href="${system.basePath}/css/mine_gift.css" rel="stylesheet">
</head>
<body>

<!--head-->
<div class="header">
    <!--微公益-->
    <div class="headerTop">
        <p class="user"><img src="${system.basePath}/img/common/back.png" alt=""/></p>
        <p class="headerTitle">交易详情</p>
    </div>
</div>
<!--section-->
<div id="offCanvasContentScroll" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div class="section ">
            <ul class="giftDel mui-table-view pzDelUl">
            	<!-- 
	                <li class="mui-table-view-cell over">
	                    <p class="pzTitle">交易ID</p>
	                    <p class="pzDel">${transaction.txid?if_exists}</p>
	                </li>
                -->
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">交易金额</p>
                    <p class="pzDel">&yen;${transaction.transMoney?if_exists} <span class="deStatus">（交易已确认）</span></p>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">所在区块哈希</p>
                    <u class="pzDel uuid" id="${donorTransRel.blockHeight?if_exists}">${donorTransRel.blockHash?if_exists}</u>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">接收时间</p>
                    <p class="pzDel">${transaction.tranGenTime?if_exists}</p>
                </li>
                <li class="mui-table-view-cell over">
                    <p class="pzTitle">合约ID</p>
                    <p class="pzDel">${donorTransRel.contractIdStr?if_exists}</p>
                </li>
            </ul>
            <!--tu-->
            <ul class="pzIcon giftDel">
            	<#if type?if_exists ='draw'>
		               <li class="moneyIcon">
		                    <p class="lxIcon"><img src="${system.basePath}/img/common/pzIcon-1.png" alt=""/></p>
		                    <div class="lxTxt pzJk"><p>合约账户</p><p>¥${transaction.transMoney?if_exists} </p></div>
		                    <div class="lxTxt pzQkl"><p>施工方账户</p><p>¥${transaction.transMoney?if_exists?replace('-','' )} </p></div>
	              	  </li>
	            <#else>
	            	<li class="moneyIcon">
	                    <p class="lxIcon"><img src="${system.basePath}/img/common/pzIcon.png" alt=""/></p>
	                    <div class="lxTxt pzJk"><p>发起捐款</p><p>¥${donorTrackDetail.donorAmountStr?if_exists} </p></div>
	                    <div class="lxTxt pzQd"><p>渠道账户</p><p>¥${donorTrackDetail.channelAmountStr?if_exists} </p></div>
	                    <div class="lxTxt pzQkl"><p>合约区块链账户</p><p>¥${donorTrackDetail.contractAmountStr?if_exists} </p></div>
	                    <div class="lxTxt pzJjgl"><p>基金管理账户</p><p>¥${donorTrackDetail.fundAmountStr?if_exists} </p></div>
	                </li>
                </#if>
            </ul>
            <!--序列化信息-->
            <ul class="info mui-table-view ">
                <li class="mui-table-view-cell over">
                    <p class="infoTitle">写入信息(区块中记录的序列化信息)</p>
                    <p class="infoDel">${transaction.payload?if_exists}</p>
                </li>
            </ul>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/mui.min.js"></script>
<script src="${system.basePath}/js/jquery-1.11.3.js"></script>

<script>
    $('.user').on('tap',function(){
        window.history.back(-1);
    });
    $('.uuid').on('tap',function(){
        //window.history.back(-1);
        var height = this.getAttribute("id");
        window.location.href="${system.basePath}/app/appBlockDetail?heigh="+height;
    });
    mui('#offCanvasContentScroll').scroll();


</script>
</body>

</html>