% read jpeg image
image = imread("/home/akram09/Projects/StudyProjects/2CSSIQTPs/IMN/TP2/cameraman.jpg");
% create a figure
figure;
% show the initial image
subplot(5, 3, 1);
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
subplot(5, 3, 2);
imshow(image_noisy_pepper);
axis('image');
axis on;
title("Image avec un bruit poivron & sel");
% add salt & paper noise
image_noisy_gaussian = imnoise(image, "gaussian");
% show resulting image
subplot(5, 3, 3);
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
subplot(5, 3, 4);
imshow(gaussian_filtered);
axis('image');
axis on;
title("Image bruit gaussian filtre passe bas");

% 2 Apply filters to pepper noisy image
pepper_filtered = imfilter(image_noisy_pepper, filter_low);
% show resulting image
subplot(5, 3, 5);
imshow(pepper_filtered);
axis('image');
axis on;
title("Image bruit poivron & sel filtre passe bas");

% 1 Apply median filter to gaussian noisy image
gaussian_filtered = medfilt2(image_noisy_gaussian)
% show resulting image
subplot(5, 3, 6);
imshow(gaussian_filtered);
axis('image');
axis on;
title("Image bruit gaussian filtre median");

% 3 Apply meidan filter to pepper noisy image
pepper_filtered = medfilt2(image_noisy_pepper)
% show resulting image
subplot(5, 3, 7);
imshow(pepper_filtered);
axis('image');
axis on;
title("Image bruit poivron & sel filtre median");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Apply High Pass Filter to both images  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
high_pass_filter = [-1 -1 -1; -1 8 -1; -1 -1 -1];
image_filtered_high_pass = imfilter(image, high_pass_filter / 9);
% show resulting image
subplot(5, 3, 8);
imshow(image_filtered_high_pass);
axis('image');
axis on;
title("filtre passe haut avec la moyenne ");
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Apply High Pass without median Filter to initial image   %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
image_filtered_high_pass = imfilter(image, high_pass_filter);
% show resulting image
subplot(5, 3, 9);
imshow(image_filtered_high_pass);
axis('image');
axis on;
title("filtre passe haut sans la moyenne ");
% on remarque qu'on a un bon resultat sans la moyenne
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Apply accentuator filter to initial image  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
accentuator_filter = [-1 -1 -1; -1 9 -1; -1 -1 -1];
image_filtered_accentuator = imfilter(image, accentuator_filter);
% show resulting image
subplot(5, 3, 10);
imshow(image_filtered_accentuator);
axis('image');
axis on;
title(" FIltre Accentuateur ");
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Fourrier Transformation of the image %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
fourrier_transf = fft2(image);
% show  modulus image
% affichage du module
subplot(5, 3, 11);
imshow(log(1 + fftshift(abs(fourrier_transf))), []);
axis('image');
axis on;
title('image du module ');

% affichage de l'argument
subplot(5, 3, 12);
imshow(angle(fftshift(fourrier_transf)), []);
axis('image');
axis on;
title("Image de l'argument");
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Fourrier Transformation of the trui image %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
image = imread("/home/akram09/Projects/StudyProjects/2CSSIQTPs/IMN/TP2/trui.png");
fourrier_transf_trui = fft2(image);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Trouvons une nouvelle image 3 %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
img3_modulus = abs(fourrier_transf);
img3_arg = angle(fourrier_transf_trui);
fourier_img3 = img3_modulus .* exp(1i * img3_arg);
img3 = ifft2(fourier_img3);

subplot(5, 3, 13);
imshow(img3, []);
axis('image');
axis on;
title('La nouvelle Image 3');

subplot(5, 3, 14);
imshow(image, []);
axis('image');
axis on;
title("L'image du trui");
