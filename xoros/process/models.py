from django.db import models


# Create your models here.
class Account(models.Model):
    username = models.CharField(primary_key=True, max_length=255)
    email = models.EmailField(null=False, max_length=255)
    password = models.CharField(null=False, max_length=255)
    first_name = models.CharField(null=False, max_length=255)
    middle_initial = models.CharField(null=False, max_length=255)
    last_name = models.CharField(null=False, max_length=255)


class Image(models.Model):
    picture = models.ImageField(upload_to='process/static/management/storage', blank=True, null=True)
