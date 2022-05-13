#!/bin/bash

./Booking.sh

./ImageBuilder.sh


echo $(tput setaf 4)$(tput bold)DEPLOYED$(tput init) booked and image generated

echo 'Enter Y/N for deletion of resources'
read choice
if [ $choice == 'Y' ]; then
  docker volume rm airplane
  docker rmi airplane-img
  docker rmi airplane-jdk

  echo $(tput setaf 2)$(tput bold)CLEANED$(tput init) " Done🧹"
fi

