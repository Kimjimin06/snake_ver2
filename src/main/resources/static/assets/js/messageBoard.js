const buttonEls = document.querySelectorAll('#btn-group .btn');
const ActiveCategoryEl = document.querySelector('section.messageBoard .container .category .categoryName.active')
const categoryNameEls = document.querySelectorAll('section.messageBoard .container .category .categoryName')



// if(!ActiveCategoryEl) {
//   categoryNames = Array.from(categoryNameEls)
//   categoryNames[0].classList.add('active')
// }

buttonEls.forEach(function(buttonEl) {
  buttonEl.addEventListener('click', function() {
    // const activeEl = document.querySelector('#btn-group .btn.active')
      if(buttonEl)  {
        // activeEl.classList.remove('active')
        // buttonEl.classList.add('active')
        // console.log(buttonEl.innerText)
        const urlParams = new URL(location.href).searchParams;
        window.location.href = `/messageBoard?category=${urlParams.get("category")}&pageGroup=${urlParams.get("pageGroup")}&groupCommunity=${buttonEl.innerText}`;
      }else {
        // buttonEl.classList.add('active')
        // console.log(buttonEl.innerText)
        window.alert("다시시도해주세요");
      }
  })
})



function check() {
  console.log('체크')
}




categoryNameEls.forEach(function(categoryNameEl) {
  categoryNameEl.addEventListener('click', function() {
    const activeEl = document.querySelector('section.messageBoard .container .category .categoryName.active')
    if(activeEl) {
      activeEl.classList.remove('active')
      categoryNameEl.classList.add('active')
      // console.log(categoryNameEl.innerText)
      // console.log((categoryNameEl.id).substr(10))
      // submitCategoryID((categoryNameEl.id).substr(10))
      window.location.href = `/messageBoard?category=${Number((categoryNameEl.id).substr(10))}&pageGroup=1&groupCommunity=1`;
    }else {
      categoryNameEl.classList.add('active')
      // console.log(categoryNameEl.innerText)
      // console.log((categoryNameEl.id).substr(10))
      // submitCategoryID((categoryNameEl.id).substr(10))
      window.location.href = `/messageBoard?category=${Number((categoryNameEl.id).substr(10))}&pageGroup=1&groupCommunity=1`;
    }
  })
})




const contentsEls = document.querySelectorAll('section.messageBoard .container .contents-group .content')

contentsEls.forEach(function (contentsEl) {
  contentsEl.addEventListener('click', function () {
    // check()
    // console.log(contentsEl.classList[1])
    window.location.href = `/post?postNum=${contentsEl.classList[1]}`;
  })
})


function beforeActive() {
  // const activeButton = document.querySelector('#btn-group .btn.active')
  // const buttonArray =  Array.from(buttonEls);
  // const targetButton = buttonArray.find(function(button) {
  //   return Number(button.innerText) === Number(activeButton.innerText) - 1;
  // })
  // if(targetButton) {
  //   activeButton.classList.remove('active')
  //   targetButton.classList.add('active')
  // } else {
  //   console.log('해당값없음')
  // }

  const urlParams = new URL(location.href).searchParams;
  window.location.href = `/messageBoard?category=${urlParams.get("category")}
                          &pageGroup=${Number(urlParams.get("pageGroup")) - 1}
                          &groupCommunity=${(Number(urlParams.get("pageGroup")) * 3) - 3}`;
  
  
  // console.log(activeButton.innerText - 1)
}


function nextActive() {
  // 현재 url의 pageGroup의 값을 가져와서 1이 아니면 그 값에 1을 추가한다. (일단 groupCommunity는 그냥 냅둔다.)
  const urlParams = new URL(location.href).searchParams;
  // console.log(urlParams.get("pageGroup") != 1)
  window.location.href = `/messageBoard?category=${urlParams.get("category")}
                          &pageGroup=${Number(urlParams.get("pageGroup")) + 1}
                          &groupCommunity=${(Number(urlParams.get("pageGroup")) * 3) + 1}`;
}


function firstActive() {
  const urlParams = new URL(location.href).searchParams;
  window.location.href = `/messageBoard?category=${urlParams.get("category")}&pageGroup=1&groupCommunity=1`;
}


function lastActive(threeList, twoList) {
  //3차원 배열(ViewpageTables)의 사이즈를 구하고 가장큰값에 해당하는 값을 pageGroup에 넣고 groupCommunity은
  // pageGroup에에 해당하는 3차원배열안에 들어있는 2차원 배열의 사이즈에서 가장큰값으로 설정해준다.
  // console.log(threeList, twoList)
  const urlParams = new URL(location.href).searchParams;
  window.location.href = `/messageBoard?category=${urlParams.get("category")}&pageGroup=${threeList}&groupCommunity=${twoList + ((threeList - 1) * 3)}`;
}