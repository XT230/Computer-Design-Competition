import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/LoginView.vue';
import MainPage from '../views/MainPage.vue';
import AIChat from '../views/AIChat.vue';
import AskForHelp from '../views/AskForHelp.vue';
import CareerPlanning from '../views/CareerPlanning.vue';
import Example from '../views/Example.vue';
import PraiseWall from '../views/PraiseWall.vue';
import Recomend from '../views/Recomend.vue';
import UserInfo from '../views/UserInfo.vue';
import Favorites from '../views/Favorites.vue';
import UserMainPageVue from '@/views/UserMainPage.vue';
import path from 'path';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/mainpage',
      name: 'mainpage',
      component: MainPage,
      children: [
        // UserHome will be rendered inside User's <router-view>
        // when /users/:username is matched
        { path: 'AIChat', component: AIChat },
        { path: 'AskForHelp', component: AskForHelp },
        { path: 'CareerPlanning', component: CareerPlanning },
        { path: 'UserMainPage', component: UserMainPageVue },
        { path: 'Example', component: Example },
        { path: 'PraiseWall', component: PraiseWall },
        { path: 'Recomend', component: Recomend },
        { path: 'UserInfo', component: UserInfo },
        { path: 'Favorites', component: Favorites },
      ],
    },
    
  ]
})

export default router
