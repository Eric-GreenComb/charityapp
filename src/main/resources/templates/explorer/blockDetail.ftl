<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="UTF-8">
    <title>区块详情</title>
    <link rel="stylesheet" href="${system.basePath?if_exists}/css/common_pc.css"/>
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv" id="backExplorerIndex">
            <img src="${system.basePath?if_exists}/img/common_pc/logo.png" alt=""/>
            <span class="logoTxt">区块链浏览器</span>
        </div>
        <div class="rt header_top_down">
            <p class="search_con">
                <input type="text" id="search" class="search" placeholder="高度、UUID、交易ID" />
                <label for="search"><a href="#"><img src="${system.basePath?if_exists}/img/common_pc/search.png" alt=""/></a></label>
            </p>
        </div>
    </div>
</div>
<!--section-->
<div class="section">
    <div class="container">
        <div class="partYi">
            <p class="partName">区块#${heigh}</p>
            <p class="partInfo"><span>时间戳</span><span>${blockInfo.blockGenTime?if_exists}</span></p>
            <p class="partInfo"><span>世界态哈希</span><span>${blockInfo.stateHash?if_exists}</span></p>
            <p class="partInfo"><span>上一区块</span><span>${blockInfo.previousBlockHash?if_exists}</span></p>
        </div>
        
        <div class="partYi">
        	<#list blockInfo.transactions?if_exists as trans>
        		<p class="partInfo"><span>包含交易ID</span><a href="javascript:goTransDetail('${trans.txid?if_exists}','${trans.transMoney?if_exists}');" class="color">${trans.txid?if_exists}</a></p>
                <p class="partInfo"><span>交易时间</span><span>${trans.tranGenTime?if_exists}</span></p>
       		 </#list>
        </div>
    </div>
</div>


<script src="${system.basePath?if_exists}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath?if_exists}/js/common_pc.js"></script>
<script>

	var bObj = document.getElementById("backExplorerIndex"); 
		bObj.addEventListener("click",backIndex,false); 
		function backIndex(){
			window.location.href="${system.basePath}/explorer/index";
		} 
function goTransDetail(txid,transMoney){
		window.location.href="${system.basePath}/explorer/transDetail?txid="+txid;

		//if("--"==transMoney){
		//	return ;
		//}else{
		//	window.location.href="${system.basePath}/explorer/transDetail?txid="+txid;
		//}
	}
</script>
</body>
</html>