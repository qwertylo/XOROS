from django.urls import path

from . import views

app_name = 'process'
urlpatterns = [
    path('sign_up/', views.sign_up, name='sign_up'),
    path('log_in/', views.log_in, name='log_in'),
    path('predict/', views.predict, name='predict'),
]
