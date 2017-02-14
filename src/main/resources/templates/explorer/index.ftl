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
        <div class="lf secLf">
            <!--节点共识-->
            <div class="nodeAll">
                <p class="nodeTxt">节点共识</p>
                <ul class="nodeNews">
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan green" id="peer1"><span id="peer1_high">10006</span></p>
                        <p class="nodeNewsYiNew" id="peer1_address">192.168.31.100</p>
                        <p class="nodeNewsYiDian" id="peer1_name">内部节点[1]</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan gray" id="peer2"><span id="peer2_high">10005</span></p>
                        <p class="nodeNewsYiNew" id="peer2_address">192.168.31.101</p>
                        <p class="nodeNewsYiDian" id="peer2_name">内部节点[2]</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan gray" id="peer3"><span id="peer3_high">10005</span></p>
                        <p class="nodeNewsYiNew" id="peer3_address">192.168.31.102</p>
                        <p class="nodeNewsYiDian" id="peer3_name">内部节点[3]</p>
                    </li>
                    <li class="nodeNewsYi">
                        <p class="nodeNewsYiQuan green" id="peer4"><span id="peer4_high">10006</span></p>
                        <p class="nodeNewsYiNew" id="peer4_address">192.168.31.103</p>
                        <p class="nodeNewsYiDian" id="peer4_name">内部节点[4]</p>
                    </li>
                </ul>
            </div>
            <!--最新交易信息-->
            <div class="newsAll">
                <p class="nodeTxt">最新交易信息</p>
                <p class="newsTitle"><span>交易ID</span><span>交易时间</span><span>交易金额</span></p>
                <ul class="newsUl">
                	<#list transList as trans>、
                		<li class="newsInfo"><a href="${system.basePath}/explorer/transDetail?txid=${trans.txid}">${trans.txid?substring(0,20)}</a><span>${trans.tranGenTime?substring(10)}</span><span>90.00&yen;</span></li>
                	</#list>
                </ul>
            </div>
        </div>
        <div class="rt secRt">
            <!--最新区块-->
            <div class="newsAll">
                <p class="nodeTxt partTxt">最新区块</p>
                <ul class="partUl">
                    <li class="newsTitle"><span>区块高度</span><span>生成时间</span></li>
                   	<#list blockHighList as blockHigh>
                		<li class="newsInfo"><a href="${system.basePath}/explorer/blockDetail?heigh=${blockHigh.blockHigh}">${blockHigh.blockHigh}</a><span>${blockHigh.blockGenTime?substring(10)}</span></li>
                	</#list>
                </ul>
            </div>
        </div>
    </div>
</div>


<script src="${system.basePath}/js/jquery-1.11.3.js"></script>
<script src="${system.basePath}/js/common_pc.js"></script>
<script>


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
					$("#peer4_high").html(data.height-1);
					
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
         	var peerUrl="http://192.168.31.100:7050/chain";
			queryCurrentPeerStatus(peerUrl);
			
			setTimeout("refreshPeer()",60000);
    }
    refreshPeer();
</script>
</body>
</html>