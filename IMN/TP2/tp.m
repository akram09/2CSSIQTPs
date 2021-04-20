% read jpeg image
image = imread("/home/akram09/Projects/StudyProjects/2CSSIQTPs/IMN/TP2/cameraman.jpg");
% create a figure
figure;
% show the initial image
subplot(3, 6, 1);
imshow(image);
axis('image');
axis on;
title("Image cameraman.jpg");
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Applying different noises to image
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% add salt & paper noise
image_noisy_pepper = imnoise(image, "salt & pepper");
% show resulting image
subplot(3, 6, 2);
imshow(image_noisy_pepper);
axis('image');
axis on;
title("Image avec un bruit poivron & sel");
% add salt & paper noise
image_noisy_gaussian = imnoise(image, "gaussian");
% show resulting image
subplot(3, 6, 3);
imshow(image_noisy_gaussian);
axis('image');
axis on;
title("Image avec un bruit gaussian");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Applying different filters to noisy images%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% 1 Apply filters to gaussian noisy image
% create our low basse filter
filter_low = ones(3, 3) / 9;
gaussian_filtered = imfilter(image_noisy_gaussian, filter_low);
% show resulting image
subplot(3, 6, 4);
imshow(gaussian_filtered);
axis('image');
axis on;
title("Image bruit gaussian filtre passe bas");

% 2 Apply filters to pepper noisy image
pepper_filtered = imfilter(image_noisy_pepper, filter_low);
% show resulting image
subplot(3, 6, 5);
imshow(pepper_filtered);
axis('image');
axis on;
title("Image bruit poivron & sel filtre passe bas");

% 1 Apply median filter to gaussian noisy image
gaussian_filtered = medfilt2(image_noisy_gaussian)
% show resulting image
subplot(3, 6, 7);
imshow(gaussian_filtered);
axis('image');
axis on;
title("Image bruit gaussian filtre median");

% 3 Apply meidan filter to pepper noisy image
pepper_filtered = medfilt2(image_noisy_pepper)
% show resulting image
subplot(3, 6, 8);
imshow(pepper_filtered);
axis('image');
axis on;
title("Image bruit poivron & sel filtre median");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Apply High Pass Filter to both images  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
high_pass_filter = [-1 -1 -1; -1 8 -1; -1 -1 -1];
gaussian_filtered = imfilter(image_noisy_gaussian, high_pass_filter);
% show resulting image
subplot(3, 6, 10);
imshow(gaussian_filtered);
axis('image');
axis on;
title("Image bruit gaussian filtre passe bas");

% 2 Apply filters to pepper noisy image
pepper_filtered = imfilter(image_noisy_pepper, high_pass_filter);
% show resulting image
subplot(3, 6, 5);
imshow(pepper_filtered);
axis('image');
axis on;
title("Image bruit poivron & sel filtre passe bas");
