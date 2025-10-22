function openFlipbook(url) {
  // Pass the URL as a query parameter to viewer.html
  window.location.href = "viewer.html?url=" + encodeURIComponent(url);
}

