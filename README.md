# Game Finding Chick in Egg
Small game of ding the egg with chick inside.  

Worked on TableLayout, ImageView, Button, and onClickListener for both ImageVIew and Button.

The algorithm is:

1. Created TableLayout with three rows
   1.1 First row includes a TextView game holding title, game results, and game realtime guide (pointing to click the button to replay).
   1.2 The second row includes three ImageViews which hold one image of egg with chick, and two images without eggs.
   1.3 The third row includes a button to reset the game, so that users can continue to play.
   
2. The game starts with all three images being set with no-chick-inside.
   2.1 The activity holds an array of the IDs (resource id of the image) of the three drawable images (two of them being no-chick-inside, and on with chick-inside).
   2.2 When game starts, or user click "Play Again" button, the three images get egg-with-no-check, creating uniform look; game title/status is updated to game description; and also 
   2.3 Each element of _that array_ will exchange/swap with another elemnt chosen randomly.  This is the central piece of the game, make the egg-with-chick-inside randomly position in the three images.
   2.4 When users click one of the three images on screen, those images were replaced with drawables with resource-id saved in _image array_; also check if the click-image having chick inside, if so, game status in row 1 in TableLayout will be updated; if not, the game status also gets updated.  The clicked image will be so translucency, while the other two images will have less translucent.
   
3. Some extra improvement:  
   3.1 Added the launcher icon, better effect on phone, easy to find from apps.
   3.2 Set application orientation to userLandscape (either way of landscape;  if use landscape, and then it's one one way of landscape); userLandscape is best for user experience.
   3.3 Added a vairable to track if user has already played, if user click any images after playing once, the game status will be updated to playing-guidance: prompting users to click "Play Again" button to reset the game.
   3.3 Updates the title, game status, and game guidance with different color scheme and text.
   
4. ToDos:

   4.1 Add some menu for settings; or menu of taking screen snapshot, and share with other apps like wechat, QQ etc.

   4.2 Here it goes, the randomization algorithm can be improved. Simply assign index (0, 1, or 2 randomly chosen) to that egg-with-chick;  and then the other two simply use the other egg-no-chick image.
