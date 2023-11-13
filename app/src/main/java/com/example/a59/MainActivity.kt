package com.example.a59

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(n: Int, m: Int, section: IntArray): Int {
                //벽을 1미터 길이의 구역 n개, 벽에 페인트를 칠하는 룰러의 길이 m
                //다시 페인트를 칠하기로 정한 구역들의 번호 배열 section
                //룰러로 페인트칠해야하는 최소횟수를 return

                var answer: Int = 0

                //값 초기화
                var wall = Array<Boolean>(n,{true})
                for(i in 0..section.size-1){
                    wall[section[i]-1]=false
                }

                //페인트칠 갯수 파악하기
                for(i in 0..wall.size-1){
                    if(wall[i]) continue //칠해져 있으면 넘어가자
                    if(!wall.contains(false)) break //만약 다 칠해져있으면 break

                    for(j in i..i+m-1){
                        if(j==wall.size) break

                        wall[j]=true
                    }
                    answer++
                }

                return answer
            }

        }
        val a = Solution()
        a.solution(8,4,intArrayOf(2,3,6))
        a.solution(5,4,intArrayOf(1,3))
        a.solution(4,1,intArrayOf(1,2,3,4))
    }
}