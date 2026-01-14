<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios from 'axios'

// 1. 定义数据结构 (类似 Java 的 Entity)
interface Task {
  id: number;
  title: string;
  description: string;
  completed: boolean;
  createdAt: string;
}

// 2. 定义状态 (响应式变量)
const tasks = ref<Task[]>([])
const loading = ref(false)
const newTaskTitle = ref('') // 用来绑定输入框的值

// 3. 定义方法 (async/await 异步编程)
const fetchTasks = async () => {
  loading.value = true
  try {
    const response = await axios.get('http://localhost:8081/api/tasks/page?current=1&size=10')
    if (response.data.code === 200) {
      tasks.value = response.data.data.records
    }
  } catch (error) {
    console.error('获取任务失败:', error)
  } finally {
    loading.value = false
  }
}

const addTask = async () => {
  if (!newTaskTitle.value.trim()) {
    alert('请输入任务标题！')
    return
  }

  try {
    const response = await axios.post('http://localhost:8081/api/tasks', {
      title: newTaskTitle.value,
      description: '由前端创建'
    })
    
    if (response.data.code === 200) {
      // 创建成功后，清空输入框
      newTaskTitle.value = ''
      // 重新拉取列表以刷新页面
      fetchTasks()
    }
  } catch (error) {
    console.error('添加失败:', error)
  }
}

// 4. 生命周期钩子：页面一加载就执行
onMounted(fetchTasks)
</script>

<template>
  <div class="container">
    <h1>Task Master - 任务管理</h1>
    
    <!-- 新增任务输入区 -->
    <div class="add-box">
      <input 
        v-model="newTaskTitle" 
        placeholder="输入新任务标题..." 
        @keyup.enter="addTask"
      />
      <button @click="addTask">添加</button>
    </div>
    
    <div v-if="loading">加载中...</div>
    
    <ul v-else class="task-list">
      <li v-for="task in tasks" :key="task.id" class="task-item">
        <div class="task-info">
          <span :class="{ 'completed-text': task.completed }">{{ task.title }}</span>
          <p class="desc">{{ task.description || '无描述' }}</p>
        </div>
        <div class="status">
          {{ task.completed ? '✅ 已完成' : '⏳ 待办' }}
        </div>
      </li>
    </ul>

    <div v-if="tasks.length === 0 && !loading">
      目前没有任务，快去后端创建一个吧！
    </div>
  </div>
</template>

<style scoped>
.container {
  max-width: 600px;
  margin: 40px auto;
  padding: 20px;
  font-family: 'Segoe UI', Arial, sans-serif;
}

.add-box {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

.add-box input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.add-box button {
  padding: 10px 20px;
  background-color: #42b883;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.add-box button:hover {
  background-color: #33a06f;
}

.task-list {
  list-style: none;
  padding: 0;
}

.task-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px;
  border-bottom: 1px solid #eee;
}

.desc {
  font-size: 0.8em;
  color: #666;
  margin: 5px 0 0 0;
}

.completed-text {
  text-decoration: line-through;
  color: #999;
}

.status {
  font-size: 0.9em;
}
</style>