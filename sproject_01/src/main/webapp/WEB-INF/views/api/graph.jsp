<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header -->
<%@ include file="../layout/header.jsp" %>
<!-- //header -->
<jsp:useBean id="now" class="java.util.Date"/>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">CUSTOMER</a></li>
				<li class="last">NOTICE</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">CUSTOMER<span>고객센터</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">NOTICE</a></li>
					<li><a href="#" id="leftNavi2">1:1문의</a></li>
					<li><a href="#" id="leftNavi3">FAQ</span></a></li>
					<li class="last"><a href="#" id="leftNavi4">이용안내</a></li>
				</ul>	
			</div><script type="text/javascript">initSubmenu(1,0);</script>
			
			<script>
				function dataBtn(){
					let syearMonth = [];
					let amount = [];
					alert("그래프를 출력합니다.");
					
					//차트리셋
					let chartStatus = Chart.getChart("myChart"); // <canvas> id
						if (chartStatus != undefined) {
							chartStatus.destroy();
						}
					
					//ajax데이터 불러오기
					$.ajax({
						url:"/api/graph_data",
						type:"get",
						dataType:"json",
						data:{"syearMonth":$("#syearMonth").val()},//select값 넣어주기
						success:function(data){
							//console.log(data);
							/*json방식*/
							for(let i=0;i<data.length;i++){
								//console.log("data : "+data[i].syearMonth);
								syearMonth.push(data[i].syearMonth);
								amount.push(data[i].amount);
							}
							
							console.log("syearMonth 배열 : "+syearMonth)
							console.log("amount 배열 : "+amount)
							
							//차트-----------------------------------------
						  	const ctx = document.getElementById('myChart');
						
						    new Chart(ctx, {
						      type: 'bar',
						      data: {
						        labels: syearMonth,//syearMonth 배열값을 입력
						        datasets: [{
						          label: '# 월별 매출액',
						          data: amount,//amount 배열값을 입력
						          backgroundColor: [
		  	                             'rgba(255, 99, 132, 0.2)',
		  	                             'rgba(54, 162, 235, 0.2)',
		  	                             'rgba(255, 206, 86, 0.2)',
		  	                             'rgba(75, 192, 192, 0.2)',
		  	                             'rgba(153, 102, 255, 0.2)',
		  	                             'rgba(255, 159, 64, 0.2)'
		  	                             ],
						          borderWidth: 1
						        }]
						      },
						      options: {
						        scales: {
						          y: {
						            beginAtZero: true
						          }
						        }
						      }
						    });//차트-----------------------------------------------
							
						},//success
						error:function(){alert("실패");}
					})//ajax
					
					
					
				}
			</script>

			<!-- contents -->
			<div id="contents">
				<div id="customer" style="height: 500px;">
					<div>
						<select name="syearMonth" id="syearMonth">
							<option value="2025">2025년도</option>
							<option value="2026">2026년도</option>
						</select>
					</div>	

					<h2><strong>월별매출</strong><span>쟈뎅샵 월별 매출액을 알려드립니다.</span></h2>
					
					<div class="orderDivMt">
						<div>
							<canvas id="myChart"></canvas>
						</div>


					</div>
					
					<div class="btnAreaList" style="margin-top: 20px;">
						<div class="bwright">
							<ul>
								<li><a onclick="dataBtn()" class="sbtnMini">그래프 출력하기</a></li>
							</ul>
						</div>

					</div>
				</div>
				<!-- //contents -->
	
			</div>
		</div>
	</div>
	<!-- //container -->

<!-- footer -->
<%@ include file="../layout/footer.jsp" %>
<!-- //footer -->