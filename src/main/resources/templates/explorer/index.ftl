<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="${system.basePath}/css/common_pc.css"/>
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="lf logoDiv" id="backExplorerIndex" >
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
        <div class="lf secLf">
            <!--节点共识-->
            <div class="nodeAll">
                <p class="nodeTxt">节点共识</p>
                <ul class="nodeNews">
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan green" id="peer1"><span id="peer1_high">0</span></p>
                        <p class="nodeNewsYiNew" id="peer1_address">${hostip1?if_exists}</p>
                        <p class="nodeNewsYiDian" id="peer1_name">${hostname1?if_exists}</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan gray" id="peer2"><span id="peer2_high">0</span></p>
                        <p class="nodeNewsYiNew" id="peer2_address">${hostip2?if_exists}</p>
                        <p class="nodeNewsYiDian" id="peer2_name">${hostname2?if_exists}</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan gray" id="peer3"><span id="peer3_high">0</span></p>
                        <p class="nodeNewsYiNew" id="peer3_address">${hostip3?if_exists}</p>
                        <p class="nodeNewsYiDian" id="peer3_name">${hostname3?if_exists}</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan green" id="peer4"><span id="peer4_high">0</span></p>
                        <p class="nodeNewsYiNew" id="peer4_address">${hostip4?if_exists}</p>
                        <p class="nodeNewsYiDian" id="peer4_name">${hostname4?if_exists}</p>
                    </li>
                </ul>
            </div>
            <!--最新交易信息-->
            <div class="newsAll">
                <p class="nodeTxt">最新交易信息</p>
	                <p class="newsTitle"><span>交易ID</span><span>交易时间</span><span>事件</span><span>交易金额&yen;</span></p>
                <ul class="newsUl">
                	<div id="newerBlockTransLi">
		                <#if (transList?if_exists?size > 0)>
		                	<#list transList as trans>
		                		<li class="newsInfo blockTransLi"><a href="javascript:goTransDetail('${trans.txid}','${trans.transMoney?if_exists}');">${trans.txid?substring(0,20)}...</a><span>${trans.tranGenTime?substring(10)}</span><span>${trans.transType?if_exists}</span><span>${trans.transMoney?if_exists}</span></li>
		                	</#list>
		                </#if>
	                </div>
                </ul>
            </div>
        </div>
        <div class="rt secRt">
            <!--最新区块-->
            <div class="newsAll">
                <p class="nodeTxt partTxt">最新区块</p>
                <ul class="partUl">
                    <li class="newsTitle newerBlockHighLi"><span>区块高度</span><span>生成时间</span></li>
	                     <#if (blockHighList?if_exists?size > 0)>
			                   	<#list blockHighList as blockHigh>
			                		<li class="newsInfo blockHighLi"><a href="${system.basePath}/explorer/blockDetail?heigh=${blockHigh.blockHigh}">${blockHigh.blockHigh}</a><span>${blockHigh.blockGenTime?substring(10)}</span></li>
			                	</#list>
	                	</#if>
                </ul>
            </div>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common_pc.js"></script>
<script>

	var bObj = document.getElementById("backExplorerIndex"); 
		bObj.addEventListener("click",backIndex,false); 
		function backIndex(){
			window.location.href="${system.basePath}/explorer/index";
		} 


	function goTransDetail(txid,transMoney){
		window.location.href="${system.basePath}/explorer/transDetail?txid="+txid;
		//if("--"==transMoney){
		//return ;
		//}else{
		//	window.location.href="${system.basePath}/explorer/transDetail?txid="+txid;
		//}
	}
	
	
	function searchDetail(){
		var searchVal=$("#searchVal").val();
		console.log("searchVal="+searchVal)
		if(""!=searchVal){
			window.location.href="${system.basePath}/explorer/searchDetail?searchVal="+searchVal;
		}else{
			alert("请输入查询条件,区块高度或是txid!")
		}
		
	}
	
	function subStr(str,len){
		if(len){
		return str.substring(0,len);
		}
		return str.substring(0,10);
	}
	

	function queryCurrentPeerStatus(peerUrl){
		var postData =  {"url":peerUrl,tm:new Date().getTime()};
			var queryCurrentPeerStatusUrl='${system.basePath}/pcapi/queryCurrentPeerStatus';
			$.ajax({
				type: 'GET',
				url: queryCurrentPeerStatusUrl,
				data:postData,
				dataType:'json',
				cache: false,
				async: true,//同步方法
				success: function(data){
					$("#peer1_high").html(data.height);
					$("#peer2_high").html(data.height);
					$("#peer3_high").html(data.height);
					$("#peer4_high").html(data.height);
					
					var peer1_high =$("#peer1_high").html();
					var peer2_high =$("#peer2_high").html();
					var peer3_high =$("#peer3_high").html();
					var peer4_high =$("#peer4_high").html();
					console.log("11peer1_high="+peer1_high+" peer2_high="+peer2_high+" peer3_high="+peer3_high+" peer4_high="+peer4_high);
					if(peer2_high<peer1_high){
						$("#peer2").removeClass("gray").removeClass("green").addClass("gray");
					}else{
						$("#peer2").removeClass("gray").removeClass("green").addClass("green");
					}
					if(peer3_high<peer1_high){
						$("#peer3").removeClass("gray").removeClass("green").addClass("gray");
					}else{
						$("#peer3").removeClass("gray").removeClass("green").addClass("green");
					}
					if(peer4_high<peer1_high){
						$("#peer4").removeClass("gray").removeClass("green").addClass("gray");
					}else{
						$("#peer4").removeClass("gray").removeClass("green").addClass("green");
					}
				}
			});
	}

		 function refreshPeer()
    {
         	var peerUrl="${currentPeerUrl?if_exists}";
			queryCurrentPeerStatus(peerUrl);
			
			setTimeout("refreshPeer()",60000);
    }
    refreshPeer();
    
    
    
    function refreshHigh(){
    	    var postData =  {tm:new Date().getTime()};
			var queryBlockHighListUrl='${system.basePath}/pcapi/queryBlockHighList';
			$.ajax({
				type: 'GET',
				url: queryBlockHighListUrl,
				data:postData,
				dataType:'json',
				cache: false,
				async: true,//同步方法
				success: function(data){
					$(".blockHighLi").remove();
					var blockInfoStr="";
					 $.each(data,function(key,val){ 
					 		var timestr=subStr(val.blockGenTime);
						  	blockInfoStr="<li class=\"newsInfo blockHighLi\"><a href=\"${system.basePath}/explorer/blockDetail?heigh="+val.blockHigh+"\">"+val.blockHigh+"</a><span>"+timestr+"</span></li>";
						  	console.log("blockInfoStr="+blockInfoStr);
						  	//$(".blockHighLi").append(blockInfoStr);
						  	$(".newerBlockHighLi").append(blockInfoStr);
	              	 }) 
				}
			});
    }
    
    
    
    function refreshTrans(peerUrl){
    	 var postData =  {tm:new Date().getTime()};
			var queryTransListUrl='${system.basePath}/pcapi/queryTransList';
			$.ajax({
				type: 'GET',
				url: queryTransListUrl,
				data:postData,
				dataType:'json',
				cache: false,
				async: true,//同步方法
				success: function(data){
						$("#newerBlockTransLi").empty();
						var transInfoStr="";
						 $.each(data,function(key,val){ 
						 		var timestr=subStr(val.tranGenTime);
						 		var txidstr=subStr(val.txid,15);
							  	transInfoStr="<li class=\"newsInfo blockTransLi\"><a href=\"javascript:goTransDetail('"+val.txid+"','"+val.transMoney+"');\">"+txidstr+"...</a><span>"+timestr+"</span><span>"+val.transType+"</span><span>"+val.transMoney+"</span></li>";
							  	console.log("transInfoStr="+transInfoStr);
							  	$("#newerBlockTransLi").append(transInfoStr);
		              	 }) 
				}
			});
    
    }
    
     function refreshHighAndTrans()
    {
			//refreshHigh();//刷新高度
			//refreshTrans();//刷新最新交易
			
			//setTimeout("refreshHighAndTrans()",3000);
    }
   	 //refreshHighAndTrans();
    
    
 	 function refresh() 
	{ 
	   window.location.reload(); 
	} 
	setTimeout('refresh()',10000); //指定1秒刷新一次 
</script>
</body>
</html>