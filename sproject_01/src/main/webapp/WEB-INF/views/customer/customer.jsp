<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header -->
<%@ include file="../layout/header.jsp" %>
<!-- //header -->
<jsp:useBean id="now" class="java.util.Date"/>

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


			<!-- contents -->
			<div id="contents">
				<div id="customer">
					<h2><strong>NOTICE</strong><span>쟈뎅샵 소식을 전해드립니다.</span></h2>
					
					<div class="orderDivMt">
						<table summary="NO, 제목, 등록일, 조회수 순으로 공지사항을 조회 하실수 있습니다." class="orderTable2" border="1" cellspacing="0">
							<caption>공지사항 보기</caption>
							<colgroup>
							<col width="10%" class="tnone" />
							<col width="*" />
							<col width="14%" class="tw25" />
							<col width="14%" class="tnone" />
							</colgroup>
							<thead>
								<th scope="col" class="tnone">NO.</th>
								<th scope="col">제목</th>
								<th scope="col">등록일</th>
								<th scope="col" class="tnone">조회수</th>
							</thead>
							<tbody>
								<c:forEach var="board" items="${map.list}">
								<tr>
									<td class="tnone">${board.bno}</td>
									<td class="left">
										<a href="/customer/customerView?bno=${board.bno}&page=${map.page}&category=${map.category}&search=${map.search}">${board.btitle}</a>
										<!-- 등록일을 현재날짜와 비교해 1일 이내면 new아이콘 생성 -->
										<!-- 날짜를 msec 계산해 비교 -->
										<c:if test="${c.bdate.time>=now.time-(1000*60*60*24)}">
										<img src="../images/ico/ico_new.gif" alt="NEW" />
										</c:if>
									</td>
									<td>
									<fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/>
									</td>
									<td class="tnone right">${board.bhit}</td>
								</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
						


					<div class="btnAreaList">
						<div class="bwright">
							<ul>
								<li><a href="/customer/customerWrite" class="sbtnMini">글쓰기</a></li>
							</ul>
						</div>
						<!-- 페이징이동1 -->
						<div class="allPageMoving1">
							<a href="/customer/customer?page=1&category=${map.category}&search=${map.search}" class="n"><img src="../images/btn/btn_pre2.gif" alt="처음으로"/></a>
							<c:if test="${map.page>1}">
							<a href="/customer/customer?page=${map.page-1}&category=${map.category}&search=${map.search}" class="pre"><img src="../images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
							</c:if>
							<c:if test="${map.page==1}">
							<a href="#" class="pre"><img src="../images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
							</c:if>
							<c:forEach var="i" begin="${map.startPage}" end="${map.endPage}">
								<c:if test="${map.page==i}">
									<strong>${i}</strong>
								</c:if>
								<c:if test="${map.page!=i}">
									<a href="/customer/customer?page=${i}&category=${map.category}&search=${map.search}">${i}</a>
								</c:if>
							</c:forEach>
							<c:if test="${map.page<map.maxPage}">
							<a href="/customer/customer?page=${map.page+1}&category=${map.category}&search=${map.search}" class="next"><img src="../images/btn/btn_next1.gif" alt="뒤페이지로"/></a>
							</c:if>
							<c:if test="${map.page==map.maxPage}">
							<a href="#" class="next"><img src="../images/btn/btn_next1.gif" alt="뒤페이지로"/></a>
							</c:if>
							<a href="/customer/customer?page=${map.maxPage}&category=${map.category}&search=${map.search}" class="n"><img src="../images/btn/btn_next2.gif" alt="마지막페이지로"/></a>
						</div>
						<!-- //페이징이동1 -->
					</div>

					<div class="searchWrap">
					<form action="/customer/customer" method="get" name="sFrm">
						<div class="search">
							<ul>
								<li class="web"><img src="../images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
									<select name="category" id="category">
										<option value="all" />전체</option>
										<option value="btitle" />제목</option>
										<option value="bcontent" />내용</option>
									</select>
								</li>
								<li><input type="text" name="search" id="search" class="searchInput" /></li>
								<li class="web"><a onclick="searchBtn()"><img src="../images/btn/btn_search.gif" alt="검색" /></a></li>
								<li class="mobile"><a onclick="searchBtn()><img src="../images/btn/btn_search_m.gif" alt="검색" /></a></li>
							</ul>
						</div>
					</form>
					<script type="text/javascript">
						function searchBtn(){
							const category = $("#category").val().trim();
        					const search = $("#search").val().trim();
					
							alert("검색합니다.");
							
							
							sFrm.submit();
						}
					</script>
					</div>
					<!-- //포토 구매후기 -->


				</div>
			</div>
			<!-- //contents -->

		</div>
	</div>
	<!-- //container -->

<!-- footer -->
<%@ include file="../layout/footer.jsp" %>
<!-- //footer -->