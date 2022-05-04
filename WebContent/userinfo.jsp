<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/style.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <title>Happy House | 회원 정보</title>
  </head>

  <body>
  <script type="text/javascript">
	$(()=>{
		$("#delete-button").on("click", () => {
			if (confirm("정말 삭제하시겠습니까?")) {
				location.href = "user?action=delete";
			}
		  });  
		
	})
</script>
	<%@ include file= "/include/header.jsp" %>
    <div
      class="banner"
      style="
        background-image: url('http://happyhouse.jaen.kr/images/mainbg1.jpg');
        background-position: 50% 32%;
        background-size: cover;
      "
    >
      <div class="banner-text">
        <h2 class="happyhouse">Happy House</h2>
        <hr style="color: white" />
        <!-- <div class="separator hc-element-invisible mt-10 animated hc-element-visible fadeIn" data-animation-effect="fadeIn" data-effect-delay="100"></div> -->
        <div style="color: white">행복한 우리집</div>
      </div>
    </div>
    <!-- //////////////////////// -->
    <div class="signup-container">
        <div class="container">
          <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li>&nbsp;> 회원 정보</a></li>
          </ol>
        </div>
      </div>
    <div
      class="main-container dark-translucent-bg"
      style="background-image: url('http://happyhouse.jaen.kr/images/background-img-6.jpg')"
    >
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-auto">
            <div
              class="main hc-element-invisible"
              data-animation-effect="fadeInUpSmall"
              data-effect-delay="100"
              style="color: black"
            >
              <div class="form-block p-30 light-gray-bg border-clear">
                <h2 class="title" id="userinfo-title" style="color: gray">회원 정보 확인</h2>

                <form class="form-horizontal">
                  <div class="form-group has-feedback row">
                    <label for="inputId" class="col-md-3 control-label text-md-right col-form-label"
                      >아이디
                      <span class="text-danger small">*</span>
                    </label>
                    ${userinfo.id}
                    <div class="col-md-8" id="user-info-id">
                      
                    </div>
                  </div>
                  <div class="form-group has-feedback row">
                    <label
                      for="inputPassword"
                      class="col-md-3 control-label text-md-right col-form-label"
                      >비밀번호
                      <span class="text-danger small">*</span>
                    </label>
                    ${userinfo.pwd}
                    <div class="col-md-8" id="user-info-pw">
                      
                    </div>
                  </div>
                  <div class="form-group has-feedback row">
                    <label
                      for="inputUserName"
                      class="col-md-3 control-label text-md-right col-form-label"
                      >이름
                      <span class="text-danger small">*</span>
                    </label>
                    ${userinfo.name}
                    <div class="col-md-8" id="user-info-name">
                      
                    </div>
                  </div>
                  <div class="form-group has-feedback row">
                    <label
                      for="inputEmail"
                      class="col-md-3 control-label text-md-right col-form-label"
                      >이메일
                      <span class="text-danger small">*</span>
                    </label>
                    ${userinfo.email}
                    <div class="col-md-8" id="user-info-email">
                      
                    </div>
                  </div>
                  <div class="form-group has-feedback row">
                    <label
                      for="inputColNum"
                      class="col-md-3 control-label text-md-right col-form-label"
                      >전화번호
                      <span class="text-danger small">*</span>
                    </label>
                    ${userinfo.tel}
                    <div class="col-md-8" id="user-info-col">
                      
                    </div>
                  </div>

                  <div class="form-group row">
                    <div class="ml-md-auto col-md-9">
                        <button type="button" id="ok-button" onClick="location.href='index.jsp'" 
                        style="background-color: deepskyblue; color: white" 
                        class="btn btn-group btn-warning btn-animated">확인</button>
                        <a href = "modify.jsp"><button type="button" id="change-button" 
                        style="background-color: deepskyblue; color: white" 
                        class="btn btn-group btn-warning btn-animated">수정</button></a>
                        <button type="button" id="delete-button" 
                        style="background-color: deepskyblue; color: white" 
                        class="btn btn-group btn-warning btn-animated">삭제</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- //////////////////////// -->
	<%@ include file = "/include/footer.jsp" %>
  </body>
</html>
