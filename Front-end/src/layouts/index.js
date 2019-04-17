import styles from './index.css';
import bone from '../assets/bone.png';
import paw from '../assets/paw.png';
import puppy from '../assets/puppy.png';
import { Layout,Avatar,Menu,Breadcrumb } from 'antd';
const { Header, Content, Sider, Footer } = Layout;

function BasicLayout(props) {
  return (
    <Layout>
    <Layout className="layout">
    <Header>
      <div className="logo" />
      <Menu
        theme="dark"
        mode="horizontal"
        defaultSelectedKeys={['2']}
        style={{ lineHeight: '64px' }}
      >
        <Menu.Item key="1">nav 1</Menu.Item>
        <Menu.Item key="2">nav 2</Menu.Item>
        <Menu.Item key="3">nav 3</Menu.Item>
      </Menu>
    </Header>
    
    <Content style={{ padding: '0 50px' }}>
      <Breadcrumb style={{ margin: '16px 0' }}>
        <Breadcrumb.Item>Home</Breadcrumb.Item>
        <Breadcrumb.Item>List</Breadcrumb.Item>
        <Breadcrumb.Item>App</Breadcrumb.Item>
      </Breadcrumb>
      <Content>{props.children}</Content>
    </Content>
    <Footer style={{ textAlign: 'center' }}>
      petsalon
    </Footer>
  </Layout>
  </Layout>
  );
  
}


export default BasicLayout;
