import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/LoginView.vue'
import MainPage from '../views/MainPage.vue'
import AIChat from '../views/AIChat.vue'
import AskForHelp from '../views/AskForHelp.vue'
import CareerPlanning from '../views/CareerPlanning.vue'
import Example from '../views/Example.vue'
import PraiseWall from '../views/PraiseWall.vue'
import Recomend from '../views/Recomend.vue'
import UserInfo from '../views/UserInfo.vue'
import Favorites from '../views/Favorites.vue'
import UserMainPage from '../views/UserMainPage.vue'
import CPArtical from '../views/CPArtical.vue'
import CPUser from '../views/CPUser.vue'
import ReadArtical from '../views/ReadArtical.vue'
import Register from '../views/Register.vue'
import Register1 from '../components/Register1.vue'
import Register2 from '../components/Register2.vue'
import Register3 from '../components/Register3.vue'
import Dialog from '../views/Dialog.vue'
import AFHContain from "../views/AFHContain.vue"
import path from 'path'
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      children: [
        { path: 'step1', component: Register1 },
        { path: 'step2', component: Register2 },
        { path: 'step3', component: Register3 }
      ]
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
        {
          path: 'CareerPlanning',
          component: CareerPlanning,
          children: [
            { path: 'CPArtical', component: CPArtical },
            { path: 'CPUser', component: CPUser }
          ]
        },
        { path: 'UserMainPage', component: UserMainPage },
        { path: 'Example', component: Example },
        { path: 'PraiseWall', component: PraiseWall },
        { path: 'Recomend', component: Recomend },
        { path: 'UserInfo', component: UserInfo },
        { path: 'Favorites', component: Favorites },
        { path: 'ReadArtical', component: ReadArtical },
        { path: 'Dialog', component: Dialog },
        { path: 'AFHContain', component: AFHContain }
      ]
    }
  ]
})

export default router
