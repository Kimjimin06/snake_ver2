let currentURL = window.location.href;

if(currentURL.includes('messageBoard') || currentURL.includes('post') || currentURL.includes('postUpdate')) {
  const messageBoardEl = document.querySelector('#messageBoard');
  messageBoardEl.classList.add('active');
} else if(currentURL.includes('detail')) {
  const detailEl = document.querySelector('#detail');
  detailEl.classList.add('active');
} else {
  const homeEl = document.querySelector('#home');
  homeEl.classList.add('active');
}
