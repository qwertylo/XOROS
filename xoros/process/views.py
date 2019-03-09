import pickle
import numpy as np
import cv2
from django.shortcuts import render

from process.models import Account
from process.preprocess import fd_hu_moments, fd_haralick, fd_histogram


# Create your views here.


def sign_up(request):

    username = ''

    if Account.objects.filter(username=username).exists():
        status = "Already Exists"
    else:
        account = Account(
            username=username,
            # other fields
        )
        account.save()
    data = {
        'status': status
    }
    return data


def log_in(request):

    username = ''
    password = ''

    if Account.objects.filter(username=username).exists():
        account = Account.objects.get(username=username)

        if account.password == password:
            status = "Success"

    data = {

    }
    return data


def predict(request):

    file = ''

    model = pickle.load(open("model.pkl", "rb"))

    fixed_size = tuple((500, 500))

    image = cv2.imread(file)

    train_labels = ['Biotin, Iron',
                    'Calcium, Magnesium, Iodine, Omega-3',
                    'Calcium, Zinc',
                    'Vitamin A, Calcium',
                    'Vitamin B12, Iron']

    # resize the image
    image = cv2.resize(image, fixed_size)

    ####################################
    # Global Feature extraction
    ####################################
    fv_hu_moments = fd_hu_moments(image)
    fv_haralick = fd_haralick(image)
    fv_histogram = fd_histogram(image)

    ###################################
    # Concatenate global features
    ###################################
    global_feature = np.hstack([fv_histogram, fv_hu_moments])

    # predict label of test image
    prediction = model.predict_proba(global_feature.reshape(1, -1)).tolist()
    # prediction = model.predict(global_feature.reshape(1, -1))

    for i in range(len(prediction)):
        print(train_labels[prediction[i]])

    data = {

    }
    return data
