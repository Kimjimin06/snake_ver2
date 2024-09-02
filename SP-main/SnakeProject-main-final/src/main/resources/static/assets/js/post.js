function goback() {
  window.history.back();
}


function fc(isMember, sessionId) {
  if(isMember == true) {
    window.alert("해당 모임에 이미 참여하셨습니다.")
    history.go(-1);
  }else {
    window.alert("해당 모임에 참여되었습니다.")
    //그리고 update실행(url이동시켜서 controller에서 update문 실행하는 메소드 실행)
    const urlParams = new URL(location.href).searchParams;
    const parameterPostNum = parseInt(urlParams.get('postNum'))
    insertTogether(parameterPostNum, sessionId)
  }
}

function insertTogether(parameterPostNum, sessionId) {
  $.ajax({
    url: '/insertTogether',
    data: {
      parameterPostNum : parameterPostNum,
      sessionId : sessionId
    },
    type: 'POST',
    success: function(rs) {
      // console.log(rs);
      if(rs == 1) {
        window.location.href = "messageBoard?category=0&pageGroup=1&groupCommunity=1"
      }
    }, error : function (xhr, status, err) {
      console.log(xhr + ', ' + status + ', ' + err)
    }
  })
}

