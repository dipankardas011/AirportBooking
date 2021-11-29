from PIL import Image


img = Image.open("src/img/Untitled.png")

m=int(0)
n=int(-1)

mxy=int(0)
nxy=int(0)

with open("data.txt") as f:
    for row in f:

        m+=1
        mxy=m*40
        arr = row[:5]

        for i in arr:
            n+=1

            if n == 3:
                img3=Image.open("src/img/walk_area.png")
                img.paste(img3,(n*37, mxy))

            nxy=n*40
            if i == '1':
                img2 = Image.open("src/img/full seat.jpg")
                img.paste(img2,(nxy,mxy))

            else:
                img1 = Image.open("src/img/empty seat.jpg")
                img.paste(img1,(nxy,mxy))
        n=-1
img.save("seatarrangement.png")