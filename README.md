# AndroidWaveView

具有高度逼真波浪效果的视图，可随Android方向传感器360°自动改变效果，可设置水波高度，振幅，频率

## Demo效果图
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot1.png) 
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot2.png) 
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot3.png) 
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot4.png) 
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot5.png) 
 ![image](https://github.com/myjoybar/AndroidWaveView/blob/master/screenshots/Screenshot6.png)  

 ## 单选或者多选的实现代码

## Sample Usage
```java
    private void setWaveZOffset(WaveBallView waveBallView, float orientationOffset,float heightPercent,float yPercent){
        waveBallView.setOrientationOffset(orientationOffset);
        waveBallView.setWaveYPercent(yPercent);
        waveBallView.setWaveHeightPercent(heightPercent);
        waveBallView.postInvalidate();
    }
```


        setWaveZOffset(waveBallView1, (float) -angle, 0.08f, 0.02f);
        setWaveZOffset(waveBallView2, (float) -angle, 0.08f, 0.25f);
        setWaveZOffset(waveBallView3, (float) -angle, 0.08f, 0.40f);
        setWaveZOffset(waveBallView4, (float) -angle, 0.08f, 0.50f);
        setWaveZOffset(waveBallView5, (float) -angle, 0.08f, 0.65f);
        setWaveZOffset(waveBallView6, (float) -angle, 0.08f, 0.80f);
        setWaveZOffset(waveBallView7, (float) -angle, 0.08f, 0.95f);
        
```

    Copyright 2016 MyJoybar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

