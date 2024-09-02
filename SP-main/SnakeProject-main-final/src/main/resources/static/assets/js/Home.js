// const roomPictureEls = [...document.querySelectorAll('section.why-us .roomPicture')]
//
// for (i = 0; i < roomPictureEls.length; i++) {
//     roomPictureEls[i].addEventListener('click', function() {
//         console.log('간다!')
//     });
// }

// 이동할때 쓸려고 만든거 (class값으로 찾음)
// const roomPictures = [];
//
// for (i = 0; i <= 4; i++) {
//     const el = document.querySelector('section.why-us .roomPicture' + i);
//     if(el) {
//         roomPictures.push(el);
//     }
// }
//
// roomPictures.forEach(function(roomPicture) {
//     roomPicture.addEventListener('click', function() {
//         console.log(this.className);
//     })
// })
//
const seatButtonEl = document.querySelector(
  "section.why-us .container .buttonGroup .seatButton"
);
const roomButtonEl = document.querySelector(
  "section.why-us .container .buttonGroup .roomButton"
);
const roomsEl = document.querySelector("section.why-us .container .rooms");
const seatEl = document.querySelector("section.why-us .container .seats");

roomButtonEl.addEventListener("click", function () {
  seatButtonEl.classList.remove("active");
  roomButtonEl.classList.add("active");

  roomsEl.style.display = "block";
  seatEl.style.display = "none";

  // seatEl.classList.add('disappear')
  // roomsEl.classList.remove('disappear')
});

seatButtonEl.addEventListener("click", function () {
  roomButtonEl.classList.remove("active");
  seatButtonEl.classList.add("active");

  seatEl.style.display = "block";
  roomsEl.style.display = "none";

  // roomsEl.classList.add('disappear')
  // seatEl.classList.remove('disappear')
});

const count1 = document.getElementsByClassName("seat").length;
const count2 = document.getElementsByClassName("selectedSeat").length;
const count3 = count1 - count2;

window.addEventListener("DOMContentLoaded", function () {
  // seatEl.classList.add('disappear')
  roomsEl.style.display = "none";

  $("#totalcount").text(count1);
  $("#usecount").text(count2);
  $("#leftcount").text(count3);

  $(".selectedSeat").css("background-color", "#6feaf6");
});

// window.onload = function() {
//
//
// }

const seatEls = document.querySelectorAll(
  "section.why-us .container .seatContainer .seat"
);
const myModal = document.getElementById("exampleModal");
const myModal2 = document.getElementById("exampleModal2");
const myInput = document.getElementById("exampleModalLabel");
const myInput2 = document.getElementById("exampleModalLabel2");

const ModalContent = document.getElementById("SeatChoose");
const ModalContent2 = document.getElementById("modal-body2");

// const modalSuccessButton = document.querySelector('section.why-us .container .modal-footer button.btn-primary')
const modalSuccessButton = document.getElementById("modalsucbtn");
const modal2Button = document.getElementById("modal2Button");

let selectId;

seatEls.forEach(function (seatEl) {
  seatEl.addEventListener("click", function () {
    selectId = seatEl.id;
    ModalContent.innerHTML = seatEl.id.substring(4) + "번 자리로 하시겠습니까?";
  });
});

modalSuccessButton.addEventListener("click", function () {
  // var start = document.getElementById('selectStartBox');
  // var end = document.getElementById('selectEndBox');
  // let selectstart = null;
  // let selectend = null;
  //
  // start.addEventListener('change', function() {
  //     selectstart = start.options[start.selectedIndex].value;
  // });
  // end.addEventListener('change', function() {
  //     selectend = end.options[end.selectedIndex].value;
  // });
  var start = $("select#selectStartBox").val();
  var end = $("select#selectEndBox").val();

  if (parseInt(start) >= parseInt(end)) {
    alert("시간이 동일하거나 종료시간이 작습니다.");
  } else {
    var startInt = parseInt(start);
    var endInt = parseInt(end);

    console.log(startInt, endInt);

    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    // console.log(starthour, endhour);

    if (endInt == 24) {
      var startdateS =
        year + "-" + month + "-" + day + " " + startInt + ":00:00";
      var enddateS = year + "-" + month + "-" + (day + 1) + " " + "00:00:00";
    } else {
      var startdateS =
        year + "-" + month + "-" + day + " " + startInt + ":00:00";
      var enddateS = year + "-" + month + "-" + day + " " + endInt + ":00:00";
    }

    console.log(startdateS);
    console.log(enddateS);

    const selectSeatEl = document.getElementById(`${selectId}`);
    // console.log(selectSeatEl.classList.contains('selectedSeat'))

    if (selectSeatEl.classList.contains("selectedSeat")) {
      alert("해당 자리는 이미 선택된 자리입니다. 다른자리를 선택해 주세요.");
      return false;

      // ModalContent2.innerHTML = "해당 자리는 이미 선택된 자리입니다. 다른자리를 선택해 주세요."
    } else if (
      !selectSeatEl.classList.contains("selectedSeat") &&
      selectSeatEl.classList.contains("seat")
    ) {
      // ModalContent2.innerHTML = "자리배치가 완료되었습니다."

      // 한사람당 한자리만 예약 가능
      let selectIdInt = 0;
      var defference = parseInt(end) - parseInt(start);
      console.log(defference);
      selectIdInt = parseInt(selectId.substring(4));
      $.ajax({
        url: "/updateSeat",
        data: {
          SIINum: selectIdInt,
          starttime: startdateS,
          endtime: enddateS,
          MuseTime: defference,
        },
        type: "POST",
        success: function (result) {
          console.log(result);
          if (result == 1) {
            alert("자리 배치가 완료되었습니다.");
            window.location.reload();
          } else if (result == 5) {
            alert("1인당 한자리만 예약 가능합니다.");
            return false;
          } else {
            alert("시간 충전 후 이용해주시기 바랍니다.");
            return false;
          }
        },
        error: function (xhr, status, err) {
          console.log(xhr + ", " + status + ", " + err);
        },
      });

      // modal2Button.addEventListener('click', function () {
      //     // submitForm(selectId.substring(4));
      //
      // })
    } else {
      ModalContent2.innerHTML = "오류가 발생했습니다. 다시 시도해주세요.";
    }
  }
});

modal2Button.addEventListener("click", function () {
  window.location.reload();
});

function submitForm(selectId) {
  console.log(typeof parseInt(selectId));

  let selectIdInt = 0;
  selectIdInt = parseInt(selectId);
  $.ajax({
    url: "/updateSeat",
    data: {
      selectId: selectIdInt,
    },
    type: "POST",
    success: function (result) {
      console.log(result);
      if (result == 1) {
        window.location.reload();
      }
    },
    error: function (xhr, status, err) {
      console.log(xhr + ", " + status + ", " + err);
    },
  });
}
