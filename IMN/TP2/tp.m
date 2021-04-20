% read jpeg image 
image = imread("/home/akram09/Projects/StudyProjects/IMN/TP2/cameraman.jpg");
figure;subplot(1,3,1);imshow(image);title("Image cameraman.jpg");
image_noisy_pepper = imnoise(image,'salt & pepper');
subplot(1,3,2);imshow(image_noisy_pepper);title("Image avec un bruit poivron & sel");
image_noisy_gaussian = imnoise(I,'gaussian'):
subplot(1,3,3);imshow(image_noisy_gaussian);title("Image avec un bruit gaussien");
